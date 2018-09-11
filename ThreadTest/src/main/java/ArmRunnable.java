public class ArmRunnable implements Runnable {
    volatile boolean keepRunning = true;
    public void run(){
        while (keepRunning){
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"发动了"+i+"次攻击！");
                Thread.yield();
            }

        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
