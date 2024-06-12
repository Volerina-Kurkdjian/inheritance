package functional;

import java.util.List;

public class MainFunctional {


    public static void main(String[] args) {
        PeopleCollection collection=new PeopleCollection();
        collection.add(new Person("Ion",26));
        collection.add(new Person("Maria",16));
        collection.add(new Person("Ionela",36));
        collection.add(new Person("Ionica",46));
        collection.add(new Person("Marian",22));
        collection.add(new Person("Augusta",30));
        collection.add(new Person("Stanica",15));
        collection.add(new Person("Ana",20));
        collection.add(new Person("Africa",33));





        List<Person> minors=collection.where(new Checkable<Person>(){//anonymous class example
            @Override
            public boolean test(Person person) {
                if(person.getAge()<18){
                    return true;
                }
                return false;
            }
        });

        printPeople(minors);



        List<Person> adults=collection.where(p-> p.getAge()>18);//lambda expression example
        printPeople(adults);

    }


    static void printPeople(List<Person> personList){

        for(Person p:personList){
            System.out.println(String.format("Name: %s, age: %s",p.getName(),p.getAge()));
        }

    }

}
