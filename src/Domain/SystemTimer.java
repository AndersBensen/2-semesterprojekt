/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Acquaintance.IVisualController;

/**
 *
 * @author lalal
 */
public final class SystemTimer implements Runnable {

    private final int DEFAULT_TIMER = 10;
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
                System.out.println(currentTimer);
                
            }
            IVC.logout();
            clearThread();
        }

    }

}
