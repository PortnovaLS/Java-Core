package Lesson3;

import java.util.ArrayList;

public class ArrayChange<T> {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String1");
        arrayList.add("String2");

        ArrayChange<String> arrayChange = new ArrayChange<>();


        System.out.println(arrayChange.arrayChange(arrayList));

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(3);
        arrayList1.add(6);

        ArrayChange<Integer> arrayChange1 = new ArrayChange<>();

        System.out.println(arrayChange1.arrayChange(arrayList1));

    }

    public ArrayList<T> arrayChange(ArrayList<T> arrayList) {
        T value = arrayList.get(0);

        arrayList.set(0, arrayList.get(1));
        arrayList.set(1, value);

        return arrayList;


    }
}
