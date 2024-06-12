package threads;

public class Worker implements Runnable{
   private volatile boolean terminated;//the CPU is not going to cache this variable
//it may work fine without the volatile keyword because :
//1. variables can be stored on the main memory without the volatile keyword
//2. both of the threads may use the same cache!
    @Override
    public void run() {

        while(!terminated){
            System.out.println("Working class is running");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}

class Volatile{
    public static void main(String[] args) {
        Worker worker=new Worker();

        Thread thread=new Thread(worker);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("Algorithm terminted ");
    }
}
