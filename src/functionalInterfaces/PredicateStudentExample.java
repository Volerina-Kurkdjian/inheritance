package functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

   static Predicate<Student> p1=(student)->student.getGradeLevel()>=3;
   static Predicate<Student> p2=(student)->student.getGpa()>=3.9;

    public static void filterStudentsByGradelevel(){
        List<Student> studentList=StudentDataBase.getAllStudents();
        //inline lambda Consumer that uses a Predicate to filter
        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentsByGpa(){
        List<Student> students=StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudents(){
        System.out.println("Filter Students by gpa and grade!");
        List<Student> list=StudentDataBase.getAllStudents();
        list.forEach((student -> {
            if(p1.and(p2).test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void main(String[] args) {

        filterStudentsByGradelevel();
        System.out.println("\n");
        filterStudentsByGpa();
        System.out.println("\n new fct");
        filterStudents();
    }
}
