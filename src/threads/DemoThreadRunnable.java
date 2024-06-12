package threads;

public class DemoThreadRunnable {
    public static void main(String[] args) {
        System.out.println("begin");//va afisa 0 oara
        (new ReadinventoryThread()).start();//va afisa prima data
        (new Thread(new PrintData())).start();//va afisa ultima oara
        (new ReadinventoryThread()).start();//va afisa a 3-a oara
        System.out.println("end");//va afisa a doua oara
    }
}
