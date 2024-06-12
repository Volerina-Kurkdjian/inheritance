package functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

//accepts two inputs, 1 list of students, 2 a predicate
public class BiFunctionExample {

    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction=((students,studentPredicate)->{

        Map<String,Double> studentGrademap=new HashMap<>();

        students.forEach((student)->{
            if(studentPredicate.test(student)){
                studentGrademap.put(student.getName(),student.getGpa());
            }
        });
        return studentGrademap;
    });

    public static void main(String[] args) {

        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateConsumerExample.studentPredicate1));
    }
}
