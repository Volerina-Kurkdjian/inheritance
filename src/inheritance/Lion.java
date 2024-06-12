package inheritance;

public class Lion extends Animal{

    public void setProperties(int age, String n){
        setAge(age);
        name=n;
    }

    public void roar(){
        System.out.println(name+" ,age "+getAge()+" says Roar!");
    }

    String type="bat";
    public String getType(){
        return super.type+" "+this.type;
    }
}
