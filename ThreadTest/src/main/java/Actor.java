public class Actor extends Thread{
    public void run(){
        System.out.println(getName()+"登台演出了！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(getName()+"登台演出："+(++count)+"次！");
            if(count == 1000){
                keepRunning = false;
            }
            if(count%10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(getName()+"登台演出："+(++count)+"次！");
        System.out.println(getName()+"演出结束!");

    }

    public static void main(String args[]){
        Thread actor = new Actor();
        actor.setName("程咬金");
        actor.start();
        Thread actress = new Thread(new Actress(),"秦琼");
        actress.start();
    }

}

class Actress implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+"登台演出了！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(Thread.currentThread().getName()+"登台演出："+(++count)+"次！");
            if(count == 1000){
                keepRunning = false;
            }
            if(count%10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(getName()+"登台演出："+(++count)+"次！");
        System.out.println(Thread.currentThread().getName()+"演出结束!");
    }
}
