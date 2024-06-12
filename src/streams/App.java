package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10,12,12,5};


        Arrays.stream(nums).forEach(System.out::println);
        int sum=Arrays.stream(nums).sum();
        System.out.println(sum);

        System.out.println("filtering ");
        IntStream.range(0,10).filter(x->x>4).forEach(x-> System.out.println(x+" "));

        //EXERCISE #4
        //Find the number of genres of each director's movies:
        Movie m=new Movie(1,"The Godfather",199,"imdb");
        Movie m2=new Movie(2,"Michael",199,"imdb");
        Genre genre=new Genre(1,"comedy");
        Genre genre1=new Genre(2,"thriller");
        Director director=new Director(1,"Schoppenhour","imdb");


        String[] names={"Adam","Martha","Kevin","Brad","Susane","Joe"};

        Stream.of(names).forEach(System.out::println);
        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        Stream.of(names).filter(x->x.startsWith("A")).forEach(s -> {});
        Stream.of(names).filter(x->x.startsWith("A")).forEach(System.out::println);

        //streams with custom objects
        List<Book> books=new ArrayList<>();

        books.add(new Book("Being and Time", "Titlu",560,Type.FICTION));
        books.add(new Book("Being and Time", "Titlu1",160,Type.HISTORY));
        books.add(new Book("Being and Time", "Titlu2",760,Type.NOVEL));
        books.add(new Book("Being and Time", "Titlu3",1560,Type.PHILOSOPHY));
        books.add(new Book("Mitu", "Titlu4",5560,Type.THRILLER));
        books.add(new Book("Nitu", "Titlu5",50000,Type.THRILLER));

        books.stream().forEach(System.out::println);
        List<Book> bookList= books.stream().filter(t->t.getType()==Type.NOVEL).collect(Collectors.toList());
        System.out.println("\n");
        bookList.stream().forEach(System.out::println);
        System.out.println("\nThis is the arrays :"+Arrays.toString(bookList.toArray()));

        System.out.println("\n");
        List<Book> result=books.stream().sorted(Comparator.comparing(Book::getPages)).collect(Collectors.toList());
        result.stream().forEach(System.out::println);

        //obtinem o lista de autori ai cartilor de tip thriller sortate in fct de nr de pagini
        List<String> authors=books.stream().filter(b->b.getType()==Type.THRILLER)
                .sorted(Comparator.comparing(Book::getPages))
                .map(Book::getAuthor)
                .collect(Collectors.toList());

        authors.stream().forEach(System.out::println);

        //Obtain a map with the Type as key and the books as value

        System.out.println("\nThis is the map of books ");
        Map<Type,List<Book>> booksByType= books.stream().collect(Collectors.groupingBy(Book::getType));
        booksByType.entrySet().stream().forEach(System.out::println);


        //finding longest books based on pg no
        List<String> longestBooks=books.stream().sorted(Comparator.comparing(Book::getPages)).map(Book::getTitle).collect(Collectors.toList());
        longestBooks.stream().forEach(System.out::println);

        //2 first Books from the list of longest books based on pg no
        System.out.println("\nTwo largest books");
        List<String> twoLargestBooks=books.stream().filter(p->p.getPages()>500).map(p->p.getTitle()).limit(2).collect(Collectors.toList());
        twoLargestBooks.stream().forEach(System.out::println);

        System.out.println("\n Exercise: ");
        //   Your task is to select all the book where the title is made up of exactly 2 words.

//        Book [title=The Trial, author=Franz Kafka, pages=240, type=NOVEL]
//        Book [title=Ancient Greece, author=Robert F., pages=435, type=HISTORY]
//        Book [title=Ancient Rome, author=Robert F., pages=860, type=HISTORY]
//        Book [title=The Stranger, author=Albert Camus, pages=560, type=NOVEL]

        List<Book> booksExercises=new ArrayList<>();

        booksExercises.add(new Book("Franz Kafka", "The Trial",240,Type.NOVEL));
        booksExercises.add(new Book("Robert F.", "Ancient Greece",435,Type.HISTORY));
        booksExercises.add(new Book("Albert Camus", "The Stranger",560,Type.NOVEL));
        booksExercises.add(new Book("Robert F.", "Ancient Rome",860,Type.HISTORY));
        booksExercises.add(new Book("Hermann Broch", "Death of Virgil",590,Type.NOVEL));
        booksExercises.add(new Book("Agatha Christie", "Death on the Nile",370,Type.THRILLER));
        booksExercises.add(new Book("Heidegger", "Being and Time",590,Type.PHILOSOPHY));





        List<String> titleOfTwoWords=booksExercises.stream().filter(p->p.getTitle().split(" ").length==2).map(Book::getTitle).collect(Collectors.toList());
        titleOfTwoWords.stream().forEach(System.out::println);

        System.out.println("\n Map() and FlatMap() example");

        //number of characters in every word [4,3,6]
        List<String> words=Arrays.asList("Adam","Ana","Daniel");
        List<Integer> lengthgs=words.stream().map(String::length).collect(Collectors.toList());
        lengthgs.stream().forEach(System.out::println);

        //a list containing the square values
        System.out.println("\n Map() and FlatMap() example");
        List<Integer> numbers=Arrays.asList(1,2,3,4);
        List<Integer> squareValues=numbers.stream().map(x->x*x).collect(Collectors.toList());
        squareValues.stream().forEach(System.out::println);

        System.out.println("\n  FlatMap() example");
        //flatMap() gets the unique characters
        //flatMap() - mapps each array not with a stream but with the contents of that stream, so there will be
        //[[1,2,3,4],[5,6,7,8,9,10]]--> [1,2,3,4,5,6,7,8,9,10] from an array with 2 arrays, we will obtain a single array with all the values from the 2 arrays
        //"hello", "shell" -> [h,e,l,o,s]
        String[] array={"hello","shell"};
        List<String> unique=Arrays.stream(array).map(w->w.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());

        unique.stream().forEach(System.out::println);


        System.out.println("=============================================");
        List<Book> booksExercisesOptional=new ArrayList<>();

        booksExercisesOptional.add(new Book("Franz Kafka", "The Trial",240,Type.NOVEL));
        booksExercisesOptional.add(new Book("Robert F.", "Ancient Greece",435,Type.HISTORY));
        booksExercisesOptional.add(new Book("Albert Camus", "The Stranger",560,Type.NOVEL));
        booksExercisesOptional.add(new Book("Robert F.", "Ancient Rome",860,Type.HISTORY));
        booksExercisesOptional.add(new Book("Hermann Broch", "Death of Virgil",590,Type.NOVEL));
        booksExercisesOptional.add(new Book("Agatha Christie", "Death on the Nile",370,Type.THRILLER));
        booksExercisesOptional.add(new Book("Heidegger", "Being and Time",590,Type.PHILOSOPHY));


        //total nb of books
        System.out.println(booksExercisesOptional.stream().count());







    }
}
