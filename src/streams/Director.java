package streams;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private int id;
    private String name;
    private String imdb;
    private List<Movie> movies=new ArrayList<>();

    public Director(){

    }

    //, List<Movie> movies
    public Director(int id, String name, String imdb) {
        this.id = id;
        this.name = name;
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imdb='" + imdb + '\'' +
                ", movies=" + movies +
                '}';
    }
}
