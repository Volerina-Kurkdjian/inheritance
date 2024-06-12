package collections;

import java.util.List;

class Booby{
}
class Dooby extends Booby{
}
class Tooby extends Dooby{
}

public class TestClass {
    Booby b = new Booby();
    Tooby t = new Tooby();
    public void do1(List<? super Dooby> dataList){
        dataList.add(t);
        dataList.add(new Dooby());
//        dataList.add(b);
//        b = dataList.get(0);
//        t = dataList.get(0);
        Dooby d = (Dooby) dataList.get(0);
        Booby db =(Dooby) dataList.get(0);
    }
    public void do2(List<? extends Dooby> dataList){
        Dooby d = dataList.get(0);
        Booby db = dataList.get(0);
        Tooby dbt = (Tooby) dataList.get(0);
//        dataList.add(t);
//        dataList.add(b);
//        dataList.add(new Booby());
        t = (Tooby) dataList.get(0);


    }
}
