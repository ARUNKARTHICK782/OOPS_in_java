package Threading;


import java.util.Arrays;

public class NeedForSync implements Runnable{
    private int amount=0;

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            if(i == 5){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            increment();
//            System.out.println("Amount : "+amount+" incremented by "+Thread.currentThread().getName());
        }
    }

     void  increment(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+" Before updating Amount : "+amount);
        int i = amount;
        System.out.println(Thread.currentThread().getName()+" i : "+i);
        amount = i+1;
        System.out.println(Thread.currentThread().getName()+" After updating Amount : "+amount);
    }

    public static void main(String[] args) {
        NeedForSync job = new NeedForSync();
        Thread thread1 = new Thread(job);
        Thread thread2 = new Thread(job);
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
}

/*
Here two threads are created and they are accessing the increment function, consider this scenario
when the thread1 reaches the increment function and prints its name and also prints the next statement
and it is accessing the amount and storing it in the 'i' variable but before it assigns the value back to the amount
variable thread2 gets the control and it access the amount variable and stores it in the i variable and it increments
the value and stores back it in the amount variable and thread2 gets the next iteration also
now the thread1 again gets the control and it assigns the incremented i value to the amount variable which is a mistake
because in the mean time the thread2 incremented and stored the value to the amount variable.


In order to solve this problem we need to use synchronized keyword in the methods that are accessing the data
variables. What synchronized does is it will give a key to the object that is accessing it, that object goes inside
the function and locks the function so that no one can enter in it, after completing its work it will leave the key
so that anybody can use it.


* */
