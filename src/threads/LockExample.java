package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class LockExample {

    ReentrantLock lock=new ReentrantLock();
    ExecutorService executor = (ExecutorService) Executors.newSingleThreadExecutor().submit(()->{

        lock.lock();
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    ExecutorService executor1 = (ExecutorService) Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
        System.out.println("Locked "+lock.isLocked());
        System.out.println("Held by this thread: "+lock.isHeldByCurrentThread());
        boolean locked= lock.tryLock();
        System.out.println("Lock acquired "+locked);
    },0,1, TimeUnit.SECONDS);

    public static void main(String[] args) {


    List<String> list=new ArrayList<>();
    ReadWriteLock lockReadWrite=new ReentrantReadWriteLock();

    ExecutorService executorService=Executors.newFixedThreadPool(2);
    Runnable writeTask=()->{
      lockReadWrite.writeLock();
      list.add("Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    Runnable readTask=()->{
        lockReadWrite.readLock().lock();
        System.out.println(list.get(0));
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    executorService.submit(writeTask);
    executorService.submit(readTask);
    executorService.submit(readTask);

    //Both read tasks are executed in parallel and have to wait 2 seconds until the write task has finished

        Semaphore semaphore=new Semaphore(5);
        ExecutorService executorService1=Executors.newFixedThreadPool(10);

        Runnable task=()->{
          boolean permit=false;
            try {
                permit= semaphore.tryAcquire(1,TimeUnit.SECONDS);
                if(permit){
                    System.out.println("Semaphore acquired");
                }
                else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                if(permit) semaphore.release();
            }
        };

        IntStream.range(0,10).forEach(i->executorService1.submit(task));
    }
}
