package exceptions;

public class AnimalsOutForAWalk extends RuntimeException{ }

class ExhibitClosed extends RuntimeException { }

class ExhibitClosedForLunch extends ExhibitClosed { }

class Example{
    public static void visitPorcupine() {
        try {
            seeAnimal();
        } catch (AnimalsOutForAWalk e) { // first catch block
            System.out.print("try back later");
        } catch (ExhibitClosed e) { // second catch block
            System.out.print("not today");
        }
    }

    private static void seeAnimal() {
        System.out.println("See animal! ");
    }

    public static void visitMonkeys() {
        try {
            seeAnimal();
        } catch (ExhibitClosedForLunch e) { // subclass exception
            System.out.print("try back later");
        } catch (ExhibitClosed e) { // superclass exception
            System.out.print("not today");
        }
    }

    public static void main(String[] args) {
        visitMonkeys();
        visitPorcupine();
    }

}
