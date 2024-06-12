package inheritance;

public class Fox {

    class Den{}
    public void goHome(){
        new Den();
    }

    public static void visitFriend(){
        Fox f=new Fox();
        f.new Den();
    }

}

class Squirell{

    public void visitFriend(){
        Fox f=new Fox();
        f.new Den();
    }
}

