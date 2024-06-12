package inheritance;

public class Animal {
    private int age;
    protected String name;
    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String type="mamal";
}
