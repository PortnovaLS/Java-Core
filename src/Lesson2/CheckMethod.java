package Lesson2;

public class CheckMethod {
    public static int checkArraySizeAndConversionIntAndSummary(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int value = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива превышен");
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива превышен");
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    value = value + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {

                    throw new MyArrayDataException("Ошибка в ячейке " + i + j);
                }
            }

        }

        return value;

    }
}
