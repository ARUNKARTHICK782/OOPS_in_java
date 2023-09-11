package Threading;


class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                System.out.println(exception.getMessage());
            }
            System.out.println("Thread 1 "+i);
        }
    }
}


class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread 2 "+i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable1();
        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = new MyRunnable2();
        Thread thread2 = new Thread(runnable2);


        thread1.start();
        thread2.start();

    }
}
