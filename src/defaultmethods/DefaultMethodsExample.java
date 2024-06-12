package defaultmethods;

import functionalInterfaces.Student;
import functionalInterfaces.StudentDataBase;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DefaultMethodsExample {


    public static Optional<Student> getHighestGPAStudent(){

        return StudentDataBase.getAllStudents().stream()
                //get students one by one
                .reduce((s1,s2)->{
                    if(s1.getGpa()>s2.getGpa()){
                        return s1;
                    }
                    else {
                        return s2;
                    }
                });
    }

//Stream Map+ Filter + Reduce Pattern

    private static int noOfBooks(){
     return   StudentDataBase.getAllStudents()
                .stream()
                .filter((student -> student.getGradeLevel()>3))
                .map(Student::getNoteBooks)
                .reduce(0,(a,b)->a+b);
    }


    public static Optional<Integer> findmaxValue(){
       return Optional.of(StudentDataBase.getAllStudents()
               .stream()
               .map(Student::getGradeLevel)
               //6 -> y
               //7 -> y
               //8 -> y
               //9 -> y
               //10 -> y
               //x variable holds the max value for each element in the iteration
               .reduce(0, (x, y) -> x > y ? x : y));
    }


    //from a list of 10 elements will take only the first two elements for the reduce operation
    public static Optional<Integer> limit(List<Integer> list){
      return   list.stream()
                .limit(2)
                .reduce((x,y)->x+y);
    }


    public static boolean allMatch(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch(s->s.getGpa()>=3.5);
    }

    public static boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(s->s.getGpa()>=4);
    }

    public static Optional<Student> findAnyStudent(){

        return StudentDataBase.getAllStudents().stream()
                .filter(s->s.getGpa()>=3.0)
                .findAny();
    }

    public static Optional<Student> findFirstStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGpa()>=3.0)
                .findFirst();
    }

    public static Integer sumOfNNumbers(List<Integer> integerList){

       return integerList.stream().reduce(0,(x,y)->x+y);
    }

    public static int anotherSumOfNNumbers(){

     return  IntStream.rangeClosed(1,6).sum(); //1,2,3,4,5,6,
    }




    public static void main(String[] args) {

        if(true) {

            List<String> stringList = Arrays.asList("Bogdana", "Alina", "Maria", "Felicia", "Olguta", "Matilda", "Leona", "Bianca", "Mihaela");
            Collections.sort(stringList);
            System.out.println(stringList);

            stringList.sort(Comparator.naturalOrder());

            if (getHighestGPAStudent().isPresent()) {
                System.out.println(getHighestGPAStudent());
            } else {
                System.out.println("Nothing");
            }

            System.out.println("Nb of books ");
            System.out.println(noOfBooks());
            System.out.println(findmaxValue());

            System.out.println(allMatch());
            System.out.println(anyMatch());

            System.out.println("===================================");
            System.out.println(findAnyStudent());
            System.out.println(findFirstStudent());
        }

        Stream<String> stringStream= Stream.of("adam","dan","julie");
        stringStream.forEach(System.out::println);

        Stream.iterate(1,x->x*2).limit(10).forEach(System.out::println);

        System.out.println("\n============================================");
        Supplier<Integer> supplier=new Random()::nextInt;
        Stream.generate(supplier).limit(5).forEach(System.out::println);

        List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7,8,9);





    }


}
