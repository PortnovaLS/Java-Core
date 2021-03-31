package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    HashMap<Integer, String> phonebook = new HashMap<>();

    public void add(Integer phone, String surname) {
        phonebook.put(phone, surname);
        System.out.println(phonebook);
    }

    public void get(String surname) {

        List<Integer> list = new ArrayList<>();
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        for (Map.Entry<Integer, String> o : phonebook.entrySet()) {
            if (surname == o.getValue()) {
                arr[list.size()] = o.getKey();
            }
        }
    }

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(4555578, "Ivanov");
        phoneBook.add(6770984, "Petrov");
        phoneBook.add(9067789, "Ivanov");

        phoneBook.get("Ivanov");


    }
}
