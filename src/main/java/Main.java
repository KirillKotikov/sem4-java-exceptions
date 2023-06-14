import exceptions.ArrayException;
import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Object[][] goodArray = new Object[4][4];
        Random random = new Random();
        for (int i = 0; i < goodArray.length; i++) {
            for (int j = 0; j < goodArray[i].length; j++) {
                goodArray[i][j] = random.nextInt();
            }
        }

        Object[][] arrayWithoutCorrectSizeByFirst = new Object[6][1];

        try {
            System.out.println("getSum(goodArray) = " + getSum(goodArray));
            System.out.println("getSum(arrayWithoutCorrectSizeByFirst) = " + getSum(arrayWithoutCorrectSizeByFirst));
        } catch (ArrayException ex) {
            System.out.printf("Возникла ошибка %s: %s\n", ex.getCause(), ex.getMessage());
        }

        Object[][] arrayWithoutCorrectSizeBySecond = new Object[6][1];
        try {
            System.out.println("getSum(arrayWithoutCorrectSizeBySecond) = " + getSum(arrayWithoutCorrectSizeBySecond));
        } catch (ArrayException ex) {
            System.out.printf("Возникла ошибка %s: %s\n", ex.getCause(), ex.getMessage());
        }

        Object[][] arrayWithNotInt = new Object[4][4];
        for (int i = 0; i < arrayWithNotInt.length; i++) {
            for (int j = 0; j < arrayWithNotInt[i].length; j++) {
                arrayWithNotInt[i][j] = random.nextInt();
            }
        }
        arrayWithNotInt[2][1] = "string";
        try {
            System.out.println("getSum(arrayWithNotInt) = " + getSum(arrayWithNotInt));
        } catch (ArrayException ex) {
            System.out.printf("Возникла ошибка %s: %s\n", ex.getCause(), ex.getMessage());
        }
    }

    public static int getSum(Object[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Возможно использование массива только размером 4х4",
                    new MyArraySizeException());
        } else {
            for (Object[] objects : array) {
                if (objects.length != 4) {
                    throw new MyArraySizeException("Возможно использование массива только размером 4х4",
                            new MyArraySizeException());
                }
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] instanceof Integer) {
                    result += (int) array[i][j];
                } else {
                    throw new MyArrayDataException(
                            String.format("В ячейке массива с координатами %d и %d не число!", i, j),
                            new MyArrayDataException());
                }
            }
        }
        return result;
    }
}
