package serial;

import java.io.File;
import java.util.List;

public class SerialMain {

    public static void main(String[] args) {
        String pattern="public";
        File dir=new File("./src/sample");
        File[] files=dir.listFiles();

        PatternFinder patternFinder=new PatternFinder();
        long startTime=System.currentTimeMillis();
        for(File file:files){
            //searching the file for the pattern
            List<Integer> lineNumber=patternFinder.find(file, pattern);//scan one file at a time, serial approach
            if(!lineNumber.isEmpty()){
                System.out.println(pattern+" found at line: "+lineNumber+" in the file "+file.getName());
            }
            System.out.println(file.getName());
        }

        System.out.println("Time taken for search "+(System.currentTimeMillis()-startTime));


    }
}
