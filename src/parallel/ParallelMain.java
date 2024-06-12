package parallel;

import serial.PatternFinder;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class ParallelMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String pattern="public";
        File dir=new File("./src/sample");
        File[] files=dir.listFiles();

        PatternFinder patternFinder=new PatternFinder();

        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Map<String, Future> resultMap=new HashMap<String, Future>();

        
        long startTime=System.currentTimeMillis();

        for(File file:files) {

           Future<List<Integer>> future= executorService.submit(new Callable<List<Integer>>() {

                @Override
                public List<Integer> call() throws Exception {
                    List<Integer> lineNumber=patternFinder.find(file, pattern);
                    return lineNumber;
                }
            });

           resultMap.put(file.getName(),future);
        }
        waitForAll(resultMap);
    }

    private static void waitForAll(Map<String, Future> resultMap) throws ExecutionException, InterruptedException {

            Set<String> keys = resultMap.keySet();
            for (String key : keys) {
                Future<List<Integer>> future = resultMap.get(key);
                while (!future.isDone()) {
                    ;
                }
                resultMap.put(key, (Future) future.get());
            }
    }
}
