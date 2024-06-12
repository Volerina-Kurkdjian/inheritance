package threads;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    private List<Integer> list=new ArrayList<>();

    private static final int UPPER_LIMIT=5;
    private static final int LOWER_LIMIT=0;
    private int value=1;
    private final Object lock=new Object();


    public void produce() throws InterruptedException{

        synchronized (lock){
            while(true){
                if(list.size()==UPPER_LIMIT){
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                    System.out.println("Producer lock.wait();");
                }
                else{
                    System.out.println("Adding "+value);
                    list.add(value);
                    value++;
                    lock.notify();//the other thread will be notify only when it is in a waiting state
                    System.out.println("Producer notify");
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException{

        synchronized (lock){//because both threads are synchronized on the same object lock,
            while(true){
                if(list.size()==LOWER_LIMIT){
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                    System.out.println("Consumer lock.wait();");
                }
                else{
                    System.out.println("Removing "+list.remove(list.size()-1));
                    lock.notify();
                    System.out.println("Consumer notify");

                }
                Thread.sleep(500);
            }
        }
    }


}

class Main{
    public static void main(String[] args) {
        Processor processor=new Processor();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
