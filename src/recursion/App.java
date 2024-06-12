package recursion;

 class App {

    public static void main(String[] args) {

//        SumAlgorithm sumAlgorithm=new SumAlgorithm();
//        System.out.println(sumAlgorithm.recursion(3));

//        Recursion r=new Recursion();
//        r.head(10);
//        r.tail(10);


        for(int i=0;i<4;i++){
            if(i!=0){
                System.out.println("UITE "+i);
                continue;
            }
            System.out.println("NU "+i);
        }
    }
}

class Laptop extends Computer {
    public void startup() {
        System.out.print("laptop-");
    }
}
 class Computer {
    public void startup() {
        System.out.print("computer-");
    }
    public static void main(String[] args) {
        Computer computer = new Laptop();
        Laptop laptop = new Laptop();
        computer.startup();
        laptop.startup();
    }
}

