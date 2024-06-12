package functional;

import java.util.ArrayList;
import java.util.List;

public class PeopleCollection {

    private List<Person> personList=new ArrayList<>();

    public void add(Person person){
        personList.add(person);
    }


//    public List<Person> where(Checkable<Person> personCheckable){
//
//        List<Person> filteredPersons=new ArrayList<>();
//
//        for(Person p:personList){
//
//            if(personCheckable.test(p)){
//                filteredPersons.add(p);
//            }
//        }
//
//        return filteredPersons;
//    }

    public List<Person> where(Checkable<Person> personPredicate){
        List<Person> filteredPerson=new ArrayList<>();

        for(Person p:filteredPerson){
            if(personPredicate.test(p)){
                filteredPerson.add(p);
            }
        }
        return filteredPerson;
    }


}
