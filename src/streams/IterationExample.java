package streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IterationExample {

    public static void main(String[] args) {
        List<Book> booksExercises=new ArrayList<>();

        booksExercises.add(new Book("Franz Kafka", "The Trial",240,Type.NOVEL));
        booksExercises.add(new Book("Robert F.", "Ancient Greece",435,Type.HISTORY));
        booksExercises.add(new Book("Albert Camus", "The Stranger",560,Type.NOVEL));
        booksExercises.add(new Book("Robert F.", "Ancient Rome",860,Type.HISTORY));
        booksExercises.add(new Book("Hermann Broch", "Death of Virgil",590,Type.NOVEL));
        booksExercises.add(new Book("Agatha Christie", "Death on the Nile",370,Type.THRILLER));
        booksExercises.add(new Book("Heidegger", "Being and Time",590,Type.PHILOSOPHY));

        //External Iteration
        System.out.println("\n external iteration");
        List<String> titles=new ArrayList<>();
        for(Book book:booksExercises){
            titles.add(book.getTitle());
            System.out.println(book.getTitle());
        }

        //inherently sequential approach == no parallelization
        Iterator<Book> bookIterator= booksExercises.iterator();
        while(bookIterator.hasNext()){
            titles.add(bookIterator.next().getTitle());
        }

        System.out.println("\n internal iteration");
        //stream API - internal iteration it is faster than external iteration
        List<String> titles2=booksExercises.stream().map(Book::getTitle).collect(Collectors.toList());
        titles2.forEach(System.out::println);



    }
}
