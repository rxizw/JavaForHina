public class Stage extends Thread {
    public void run(){
        ArmRunnable armySui = new ArmRunnable();
        ArmRunnable armylon = new ArmRunnable();
        //通过Runnable接口创建线程
        Thread armyOfSui = new Thread(armySui,"正规军");
        Thread armyOfLon = new Thread(armylon,"农民军");

        armyOfSui.start();
        armyOfLon.start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        armylon.keepRunning=false;
        armySui.keepRunning=false;

    }
    public static void main(String args[]){
        Stage stage = new Stage();
        stage.run();
    }
}
