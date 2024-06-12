package functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void nameAndactivities(){
        BiConsumer<String, List<String>> biConsumer=(name, activities)-> System.out.println(name+" "+activities);
        List<Student> studentList=StudentDataBase.getAllStudents();
        studentList.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));//created a consumer using a biconsumer
    }

    public static void main(String[] args) {

        BiConsumer<String,String> biConsumer=(a,b)-> System.out.println("a: "+a+" b: "+b);
        biConsumer.accept("Java 7","jva 8");

       BiConsumer<Integer,Integer>multiply=(a,b)-> System.out.println(a*b);
       multiply.accept(4,6);

       nameAndactivities();


    }
}
