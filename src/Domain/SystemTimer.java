package Domain;

import Acquaintance.IVisualController;
import javafx.application.Platform;

public final class SystemTimer implements Runnable {

    private final int DEFAULT_TIMER = 300;
    private final int ALERT_TIMER = 60;
    private int currentTimer;
    private IVisualController IVC;
    private volatile Thread timerThread;

    public SystemTimer() {
        resetTimer();
    }

    public void injectVisualController(IVisualController IVC) {
        this.IVC = IVC;
    }

    public void injectTimerThread(Thread timerThread) {
        this.timerThread = timerThread;
    }

    public void resetTimer() {
        currentTimer = DEFAULT_TIMER;
    }

    public void clearThread() {
        this.timerThread = null;
    }

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
