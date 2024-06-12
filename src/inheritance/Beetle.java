package inheritance;

public class Beetle extends Insect{

    protected int nbOfLegs=6;
    short age=3;

    public void printData(){
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);
        System.out.println(nbOfLegs);
        print();

    }

    private void print(){
        System.out.println("private method print");

    }

    public static void main(String[] args) {
        new Beetle().print();
    }
}
