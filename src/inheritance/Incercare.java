package inheritance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Incercare {

    static int f(int x){
        x=7;
       return  x;
    }

    public static void main(String[] args) {
        int y=6;
        f(y);
        System.out.println(f(y));

        Lock lock=new ReentrantLock();
        if(lock.tryLock()){
            try{
                lock.lock();
                System.out.println("Lock obtained ");
            }finally {
                lock.unlock();
                System.out.println("Once");
            }
        }

        new Thread(()-> System.out.println(lock.tryLock())).start();
    }
}
