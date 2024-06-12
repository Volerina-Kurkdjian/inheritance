package threadsafety;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManagerCyclicBarrier {

    private void removeLions(){
        System.out.println("Removing Lions");
    }

    private void cleanPen(){
        System.out.println("Cleaning the pen");
    }

    private void addLion(){
        System.out.println("Add lion");
    }

    public void performTask(CyclicBarrier c1,CyclicBarrier c2){

        try {
            removeLions();
            c1.await();
            cleanPen();
            c2.await();
            addLion();
        } catch (InterruptedException |BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ExecutorService service=null;
        try{
            service= Executors.newFixedThreadPool(4);
            var manager=new LionPenManagerCyclicBarrier();
            var cyclicbarrier1=new CyclicBarrier(4);
            var cyclicbarrier2=new CyclicBarrier(4);

            for(int i=0;i<4;i++){
                service.submit(()->manager.performTask(cyclicbarrier1,cyclicbarrier2));
            }
        }finally{
            if(service!=null) service.shutdown();
        }
    }
}
