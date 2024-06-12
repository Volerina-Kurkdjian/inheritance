package threads;

import java.lang.module.ResolutionException;
import java.util.HashMap;

public class ConcurrentCollections {

    public static void main(String[] args) {
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet())
        foodData.entrySet().remove(key);
    }
}
