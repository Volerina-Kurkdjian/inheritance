package functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
        ArrayList<String> a1 = s3.get();
//        System.out.println(a1);
//        System.out.println(s3);


        var map=new HashMap<String,Integer>();
        BiConsumer<String,Integer> b1=map::put;
        BiConsumer<String,Integer> b2= map::put;

        b1.accept("chicken",7);
        b2.accept("iolo",10);
        System.out.println(map);



    }
}
