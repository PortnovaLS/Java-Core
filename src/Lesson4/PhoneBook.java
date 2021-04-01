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

    public List<Integer> get(String surname) {

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, String> o : phonebook.entrySet()) {
            if (surname == o.getValue()) {
                list.add( o.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(4555578, "Ivanov");
        phoneBook.add(6770984, "Petrov");
        phoneBook.add(9067789, "Ivanov");

        phoneBook.get("Ivanov");

        System.out.println(phoneBook.get("Ivanov"));


    }
}
