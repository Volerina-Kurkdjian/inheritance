package inheritance;




public class Laptop extends Computer {
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

class Primate1{
    public boolean hasHair() {
        return true;
    }
}
 interface HasTail1 {
    public abstract boolean isTailStriped();
}
 class Lemur1 extends Primate1 implements HasTail1 {
    public boolean isTailStriped() {
        return false;
    }
     public boolean hasHair() {
         return false;
     }
    public int age = 10;
    public static void main(String[] args) {

        Lemur1 lemur = new Lemur1();
        System.out.println(lemur.age);

        HasTail1 hasTail = lemur;
        System.out.println(hasTail.isTailStriped());

        Primate1 primate = lemur;
        System.out.println(primate.hasHair());


    }
}

enum DaysOff {
    Thanksgiving, PresidentsDay, ValentinesDay
}
 class Vacation {
    public static void main(String... unused) {
        final DaysOff input = DaysOff.Thanksgiving;
        switch(input) {
            default:
            case ValentinesDay:
                System.out.print("1");
            case PresidentsDay:
                System.out.print("2");
        }
    }
}

