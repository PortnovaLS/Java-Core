package Lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][] {
                {"1", "9", "5", "6"},
                {"6", "2", "3", "8"},
                {"1", "9", "5", "4"},
                {"6", "2", "3", "8"},
        };

        try {
            int sum = CheckMethod.checkArraySizeAndConversionIntAndSummary(arr);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException exception){
            System.out.println(exception.getMessage());

        }




    }
}
