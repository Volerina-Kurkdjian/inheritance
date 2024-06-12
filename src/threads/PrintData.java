package threads;

public class PrintData implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println("Print record "+i);
        }
    }

//    public static void main(String[] args) {
//        System.out.println("The second thread");
//        ( new Thread(new PrintData())).start();
//    }
}


