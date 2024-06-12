package inheritance;

public class Lemur extends AnimalLemur implements HasTail{

    @Override
    public boolean isTailStripped() {
        return false;
    }

    @Override
    public boolean isAnimal() {
        return  super.isAnimal();

    }

    public int age=10;

    public  int sth(){
        return 1;
    }
}

class MainLemur{
    public static void main(String[] args) {
        Lemur lemur=new Lemur();
       // System.out.println(lemur.hasHair());

        HasTail hasTail=lemur;
        System.out.println(hasTail.isTailStripped());

//        Primate primate=lemur;
//        System.out.println(primate.hasHair());
//
//        System.out.println(((Lemur) primate).sth());

        System.out.println( lemur.sth());

        System.out.println("\n lemur.isAnimal()");
        System.out.println(lemur.isAnimal());
        System.out.println("\n al.isAnimal()");
        AnimalLemur al=lemur;
        System.out.println(al.isAnimal());



    }
}