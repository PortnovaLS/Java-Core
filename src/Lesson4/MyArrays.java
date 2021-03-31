package Lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MyArrays {
    public static void main(String[] args) {

        String[] arrayWord = {"test1", "test2", "test3", "test4", "test5", "test6", "test2", "test5", "test7", "test2", "test8", "test9",};

        HashSet<String> uniqueElements = new HashSet<>(List.of(arrayWord));

        System.out.println(uniqueElements);

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : arrayWord) {
            int currentCount = 1;

            if (map.containsKey(word)) {
                currentCount = map.get(word) + 1;
            }

            map.put(word, currentCount);

        }
        System.out.println(map);
    }
}






