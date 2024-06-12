package functionalInterfaces;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;


public class ConsumerExample {

    public static void printName( ){
        Consumer<Student> c2=(student)-> System.out.println(student);
        List<Student> students= StudentDataBase.getAllStudents();
        students.forEach(c2);
    }


    public static void printNameAndActivities(){
        Consumer<Student> c3=(student)-> System.out.println(student.getName());
        Consumer<Student> c4=(student)-> System.out.println(student.getActivities());
        List<Student> students= StudentDataBase.getAllStudents();
        students.forEach(c3.andThen(c4));//consumer chain

    }


    public static void main(String[] args) {
        Consumer<String> c1=(s)-> System.out.println(s.toUpperCase());
        c1.accept("Java 8");

        printName();
        printNameAndActivities();
    }
}
