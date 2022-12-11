import Exceptions.TheArgumentIsIargerThanTheArraySizeException;
import Exceptions.TheArgumentIsMissingException;
import Exceptions.TheArgumentIsMissingFromTheListException;

import java.util.Arrays;

public class StringListIntController implements StringListInt {
    private Integer[] integer;
    private int size;


    public StringListIntController(int size) {
        if (size > 0) {
            this.integer = new Integer[size];
            this.size = size;
        } else {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 строку");
        }
    }

    private void sorting() {

    }

    private static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private void grow() {
        integer = Arrays.copyOf(integer, size + size / 2);
    }

    @Override
    public Integer add(int item) throws TheArgumentIsMissingException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (integer[i] == null) {
                integer[i] = item;
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, int item) throws TheArgumentIsMissingException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        if (index == size) {
            grow();
        }
        quickSort(integer, 0, integer.length - 1);
        return item;
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Override
    public Integer set(int index, int item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("элемент выходит за приделы списка");
        } else {
            integer[index] = item;
            return item;
        }
    }

    @Override
    public Integer remove(int item) throws TheArgumentIsMissingException, TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingFromTheListException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (integer[i].equals(item)) {
                integer[i] = integer[i + 1];
                return item;
            }
            return item;
        }
        return item;
    }

    @Override
    public Integer removeIndex(int index) throws TheArgumentIsIargerThanTheArraySizeException {
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("элемент выходит за пределы списка");
        } else {
            for (int i = index; i < size; i++) {
                integer[i] = integer[i + 1];
            }
            return integer[index];
        }
    }

    @Override
    public boolean contains(Integer item) throws TheArgumentIsMissingException, TheArgumentIsMissingFromTheListException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < integer.length - 1; i++) {
            for (int j = 0; j < integer.length - 1 - i; j++) {
                if (integer[j] > integer[j + 1]) {
                    integer[j] = j + 1;
                    integer[j + 1]  = j;
                }
            }
        }
        containsSort(integer, item);
        return false;
    }

    private static boolean containsSort(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) throws TheArgumentIsMissingException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (integer[i].equals(item)) {
                return i;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Integer item) throws TheArgumentIsMissingException {
        if (item <= 0) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = size - 1; i > 0; i--) {
            if (integer[i].equals(item)) {
                return i;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public Integer get(int index) throws TheArgumentIsIargerThanTheArraySizeException {
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("Элемент выходит за рамки списка");
        } else {
            return integer[index];
        }
    }

    @Override
    public boolean equals(StringListController[] otherList) throws TheArgumentIsMissingException {
        if (otherList == null) {
            throw new TheArgumentIsMissingException("Значение не было передано");
        } else {
            for (int i = 0; i < size; i++) {
                if (integer[i].equals(otherList[i])) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (integer[1] == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integer, size);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            integer[i] = null;
        }
    }


}
