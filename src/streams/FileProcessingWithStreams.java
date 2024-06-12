package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessingWithStreams {

    public static void main(String[] args) throws IOException {

        String path="C:\\Users\\vbalan2\\testing\\inheritance\\src\\sample\\a.txt";
        Files.lines(Paths.get(path));
        Stream<String> namesStream=Files.lines(Paths.get(path));
        //namesStream.forEach(System.out::println); //we have to comment this line, because we can't use the same stream for more than one operation

        List<String> namesList= namesStream.collect(Collectors.toList());
        namesList.forEach(System.out::println);
        namesList.stream().filter(x->x.startsWith("A")).forEach(System.out::println);



    }
}
