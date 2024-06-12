package streams;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int id;
    private String title;

    private int year;

    private String imdb;

    private List<Genre> genres;

    private List<Director> directors;


    {
        genres=new ArrayList<>();
        directors=new ArrayList<>();
    }

    public Movie(){

    }

    //List<Genre> genres, List<Director> directors
    public Movie(int id, String title, int year, String imdb) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdb = imdb;
//        this.genres = genres;
//        this.directors = directors;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", imdb='" + imdb + '\'' +
                ", genres=" + genres +
                ", directors=" + directors +
                '}';
    }
}
