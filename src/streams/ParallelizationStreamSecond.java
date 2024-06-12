package streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelizationStreamSecond {

    public static void main(String[] args) {

        //make sure the stream can be parallelized
        //fork-join framework is used under the hood

        long now=System.currentTimeMillis();
        System.out.println(sum(100000000));
        System.out.println("Time with sequential: "+(System.currentTimeMillis()-now));
        System.out.println("\n");
        now=System.currentTimeMillis();
        System.out.println(parallelSum(100000000));
        System.out.println("Time with parallel: "+(System.currentTimeMillis()-now));

        System.out.println("\n");

        //sequential stream
        long currentTime=System.currentTimeMillis();
        long numOfPrimes= IntStream.rangeClosed(2,Integer.MAX_VALUE/100).filter(ParallelizationStreamSecond::isPrime).count();
        System.out.println("Nb of primes sequential: "+numOfPrimes);
        System.out.println("Time taken: "+(System.currentTimeMillis()-currentTime));

        System.out.println("\n");

        //parallel stream
        currentTime=System.currentTimeMillis();
        numOfPrimes= IntStream.rangeClosed(2,Integer.MAX_VALUE/100).parallel().filter(ParallelizationStreamSecond::isPrime).count();
        System.out.println("Nb of primes parallel: "+numOfPrimes);
        System.out.println("Time taken: "+(System.currentTimeMillis()-currentTime));

    }
    public static long sum(long n){
        return LongStream.rangeClosed(1,n).reduce(0,Long::sum);
    }

    private static long parallelSum(long n){
        return LongStream.rangeClosed(1,n).parallel().reduce(0,Long::sum);
    }

    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        if(num==2) return true;
        if(num%2==0) return false;

        //else we can check the numbers in the range [0,sqrt(N)]
        long maxDivisor=(long) Math.sqrt(num);

        for(int i=3;i<maxDivisor;i+=2)
            if(num%i==0)return false;

         return true;
    }
}
