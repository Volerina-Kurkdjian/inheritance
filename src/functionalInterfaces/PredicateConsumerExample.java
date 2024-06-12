package functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {

   public static Predicate<Student> studentPredicate1=(student) -> {return student.getGradeLevel()>=3;};

    Predicate<Student> getStudentPredicate2=student -> student.getGpa()>3.9;

    BiConsumer<String, List<String>> studentBiconsumer=(name, activities)-> System.out.println(name+ ": "+activities);

    BiPredicate<Integer,Double> biPredicate=(gradeLvl, Gpa)->gradeLvl>=3 && Gpa>=3.9;

    Consumer<Student> studentConsumer=(student -> {
        if(studentPredicate1.and(getStudentPredicate2).test(student)){
            studentBiconsumer.accept(student.getName(),student.getActivities());
        }
    });

    Consumer<Student> studentConsumerBiPredicate=(student -> {

        if(biPredicate.test(student.getGradeLevel(),student.getGpa())){

            studentBiconsumer.accept(student.getName(),student.getActivities());

        }
    });


    //lambda behaves the same irrespective of instance method or static method
    public void printNameAndActivities(List<Student> students){

        students.forEach(studentConsumerBiPredicate);
    }

    public void printNameAndActivities1(List<Student> students){

        students.forEach(studentConsumer);
    }
    public static void main(String[] args) {

        List<Student> studentList=StudentDataBase.getAllStudents();
        new PredicateConsumerExample().printNameAndActivities(studentList);
        System.out.println("\n------------");
        new PredicateConsumerExample().printNameAndActivities1(studentList);
    }
}
