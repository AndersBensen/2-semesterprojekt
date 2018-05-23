package Domain;

import Acquaintance.IVisualController;
import javafx.application.Platform;

public final class SystemTimer implements Runnable {

    // Timer constants
    private final int DEFAULT_TIMER = 300;
    private final int ALERT_TIMER = 60;
    
    // Information stored on the SystemTimer
    private int currentTimer;
    private IVisualController IVC;
    private volatile Thread timerThread;

    // *******************************
    // ********* Constructor *********
    // *******************************
    public SystemTimer() {
        resetTimer();
    }

    /**
     * Injects a reference to the presentation layer.
     * 
     * @param IVC IVisualController
     */
    public void injectVisualController(IVisualController IVC) {
        this.IVC = IVC;
    }

    /**
     * Injects a reference to the timer running this timer.
     * 
     * @param timerThread Thread
     */
    public void injectTimerThread(Thread timerThread) {
        this.timerThread = timerThread;
    }

    /**
     * Sets the current timer to the default timer
     */
    public void resetTimer() {
        currentTimer = DEFAULT_TIMER;
    }

    /**
     * Removes the reference to the thread
     */
    public void clearThread() {
        this.timerThread = null;
    }

    /**
     * This method is run as long as the thread is running.
     */
    @Override
    public void run() {
        
        Thread thisThread = Thread.currentThread();
        while (timerThread == thisThread) {
            while (currentTimer > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                currentTimer--;
                
                if (currentTimer == ALERT_TIMER)
                    IVC.alert();
            }
            break;
        }
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                IVC.logout();
            }
        });
        
        clearThread();
    }

}
