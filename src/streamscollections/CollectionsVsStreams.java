package streamscollections;

import functionalInterfaces.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsVsStreams {

     static List<String> namesList(){
       return  StudentDataBase.getAllStudents().stream()
               .map(s->s.getName())
               .map(String::toUpperCase)
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {


        ArrayList<String> names=new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Amy");
        names.remove(0);
        System.out.println(names);
        System.out.println(namesList());






    }
}
