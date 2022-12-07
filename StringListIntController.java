import Exceptions.TheArgumentIsIargerThanTheArraySizeException;
import Exceptions.TheArgumentIsMissingException;
import Exceptions.TheArgumentIsMissingFromTheListException;

import java.util.Arrays;

public class StringListIntController implements StringListInt {
    private final Integer[] integer;
    private int size;


    public StringListIntController(int size) {
        if (size > 0) {
            this.integer = new Integer[size];
            this.size = size;
        } else {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 строку");
        }
    }


    private void arrayExtension() {
        Integer[] integers = new Integer[size + 5];
        for (int j = 0; j < size; j++) {
            integers[j] = integer[j];
        }
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
        if (integer[index] != 0) {
            for (int i = index; i < size; i++) {
                if (integer[i] == 0) {
                    break;
                }
                integer[i + 1] = integer[i];
            }
            integer[index] = item;
        } else {
            integer[index] = item;
        }
        return item;
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
        for (int i = 0; i < size; i++) {
            if (integer[i].equals(item)) {
                return true;
            } else {
                throw new TheArgumentIsMissingFromTheListException("Такого элемента нет в списке");
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
