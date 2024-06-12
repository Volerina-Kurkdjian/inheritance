package threads;

public class ReadinventoryThread extends Thread{

    @Override
    public void run() {
        System.out.println("Print zoo");
    }

    public static void main(String[] args) {
        System.out.println("begin");//va afisa 0 oara
        (new Thread(new PrintData())).start();
        (new ReadinventoryThread()).start();//va afisa prima data
       // (new Thread(new PrintData())).start();//va afisa ultima oara
        (new ReadinventoryThread()).start();//va afisa a 3-a oara
        System.out.println("end");//va afisa a doua oara

//        System.out.println("\nRun: ");
//        (new ReadinventoryThread()).run();//va afisa prima data
//        (new Thread(new PrintData())).run();//va afisa ultima oara
//        (new ReadinventoryThread()).run();//va afisa a 3-a oara
    }
}
