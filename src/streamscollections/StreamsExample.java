package streamscollections;

import functionalInterfaces.Student;
import functionalInterfaces.StudentDataBase;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//streams manipulate the collections in a declarative way, it is like SQL
public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> studentPredicate=s->s.getGradeLevel()>=3;

        //students name and activities in a map
        Map<String, List<String>> studentMap= StudentDataBase.getAllStudents().stream()
                .filter(studentPredicate)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studentMap);




    }
}
