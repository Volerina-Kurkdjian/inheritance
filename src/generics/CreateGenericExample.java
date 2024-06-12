package generics;

class Store<T>{
    private T item;

    public void setItem(T item){
        this.item=item;
    }

    public T getItem(){
        return this.item;
    }
}

public class CreateGenericExample {

    public static void main(String[] args) {

        Store<String> store=new Store();
        store.setItem("45");
        String item=  store.getItem();
        

    }
}
