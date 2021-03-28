package Lesson3.Fruits;

import java.util.ArrayList;

public class BoxFruit<T extends Fruit> {

    private ArrayList<T> arrayList = new ArrayList<>();

    public void addFruit(T fruit) {
        arrayList.add(arrayList.size(), fruit);
    }

    public float getWeight() {

        float sum = 0;

        for (T element : arrayList) {
            sum = element.getWeight() + sum;
        }
        return sum;
    }

    public boolean compareBox(BoxFruit<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public BoxFruit<T> move(BoxFruit<T> anotherBox) {
        for (T element : arrayList) {
            anotherBox.addFruit(element);
        }
        arrayList.clear();

        return anotherBox;
    }

    @Override
    public String toString() {
        return "BoxFruit{" +
                "arrayList=" + arrayList.toString() +
                '}';
    }
}





