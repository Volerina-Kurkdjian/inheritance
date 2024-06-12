package recursion;

public class Recursion {

    public void head(int n){

        System.out.println("Calling the function recursively "+n);

        if(n==0) return;

        head(n-1);

        System.out.println("N: "+n);

    }

    public void tail(int n){//we don't have to backtrack when dealing with tail recursion, we know the solution when the base case is reached 

        System.out.println("Calling the function recursively "+n);

        if(n==0) return;

        System.out.println("The value is "+n);

        tail(n-1);

    }


}
