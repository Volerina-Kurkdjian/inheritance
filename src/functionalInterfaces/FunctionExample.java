package functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
//advantage of using lambdas plug in new features easily and more readable
public class FunctionExample {


    static Function<String,String> function=(name)->name.toUpperCase();
    static Function<String,String> addSomeString=(name)->name.toUpperCase().concat("default");

    static Function<List<Student>, Map<String,Double>> studentFunction=(students->{

        Map<String,Double> studentGradeMap=new HashMap<>();

        students.forEach((student -> {

            if(PredicateConsumerExample.studentPredicate1.test(student)) {

                studentGradeMap.put(student.getName(), student.getGpa());//populate map with name of student and value of the gpa
            }

        }));

        return studentGradeMap;
    });

    public static void main(String[] args) {

        System.out.println("Result is "+ function.apply("Acadele"));
        System.out.println("Second Result "+function.andThen(addSomeString).apply("Acadele"));

        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));


    }
}
