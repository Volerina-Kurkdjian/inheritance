package functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    //pass an Integer and check if the Integer is an even number
    static Predicate<Integer> p1=(i)->{ return i%2==0; };
    static Predicate<Integer> p2=(i)->{ return i%5==0; };

    public static void predicateAnd(){
        System.out.println("Predicate and result is: "+p1.and(p2).test(10));//predicate chaining
    }

    public static void predicateOrResultIs(){
        System.out.println("Predicate or result is: "+p1.or(p2).test(9));
        System.out.println("Predicate or result is: "+p1.or(p2).test(8));
    }

    public static void predicateNegate(){//reverse the result to false
        System.out.println("Predicate negate "+ p1.or(p2).negate().test(8));
    }

    public static void main(String[] args) {

        //System.out.println(p1.test(2));
        predicateAnd();
        predicateOrResultIs();
        predicateNegate();

    }
}
