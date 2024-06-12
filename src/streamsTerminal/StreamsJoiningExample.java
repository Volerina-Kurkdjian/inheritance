package streamsTerminal;

import functionalInterfaces.Student;
import functionalInterfaces.StudentDataBase;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class StreamsJoiningExample {
//joining has 3 overloaded versions

    public static String joining_1(){
      return  StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());

    }


    public static long count(){
        return StudentDataBase.getAllStudents().stream().collect(counting());
    }

    public static long checkPerformanceResult(Supplier<Integer> supplier,int nbOfTimes){

        long startTime=System.currentTimeMillis();

            for(int i=0;i<nbOfTimes;i++){
                supplier.get();
            }
            long endTime=System.currentTimeMillis();
            return endTime-startTime;
    }

    public static int sum_sequential_stream(){
        return IntStream.rangeClosed(1,10000).sum();
    }

    public static int sum_parallel_stream(){
        return IntStream.rangeClosed(1,10000).parallel().sum();
    }

    public static List<String> printSequentialStudActivities(){

        long startTime=System.currentTimeMillis();

       List<String> studentActivities1=StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("endTime-startTime Sequential "+ (endTime-startTime));
       return studentActivities1;
    }

    public static List<String> printParallelStudActivities(){

        long startTime=System.currentTimeMillis();

        List<String> studentActivities1=StudentDataBase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("endTime-startTime Parallel "+ (endTime-startTime));
        return studentActivities1;
    }



    public static void main(String[] args) {

        System.out.println(joining_1());
        System.out.println(count());
        System.out.println("=========================================");
        System.out.println(checkPerformanceResult(StreamsJoiningExample::sum_parallel_stream,20));
        System.out.println(checkPerformanceResult(StreamsJoiningExample::sum_sequential_stream,20));
        System.out.println("Comparing !");
        System.out.println(printSequentialStudActivities());
        System.out.println(printParallelStudActivities());

        Stream<String> stringStream= Stream.of("Ana","Maria","Magdalena","Anastasia","Roberta");
        Stream.iterate(1,x->x*2).forEach(System.out::println);
        

    }
}
