import Exceptions.TheArgumentIsIargerThanTheArraySizeException;
import Exceptions.TheArgumentIsMissingException;
import Exceptions.TheArgumentIsMissingFromTheListException;

import java.util.Arrays;

public class StringListController implements StringList {
    private final String[] string;
    private int size;

    public StringListController(int size) {
        if (size > 0) {
            this.string = new String[size];
            this.size = size;
        } else {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 строку");
        }

    }

    private void arrayExtension() {
        String[] strings = new String[size + (size / 2)];
        for (int j = 0; j < size; j++) {
            strings[j] = string[j];
        }
    }

    @Override
    public String add(String item) throws TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (string[i] == null) {
                string[i] = item;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) throws TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        if (string[index] != null) {
            for (int i = index; i < size; i++) {
                if (string[i] == null) {
                    break;
                }
                string[i + 1] = string[i];
            }
            string[index] = item;
        } else {
            string[index] = item;
        }
        return item;
    }

    @Override
    public String set(int index, String item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("элемент выходит за приделы списка");
        } else {
            string[index] = item;
            return item;
        }
    }

    @Override
    public String remove(String item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (string[i].equals(item)) {
                string[i] = string[i + 1];
                return item;
            } else {
                throw new TheArgumentIsIargerThanTheArraySizeException("такого элеманта нет в списке");
            }
        }
        return item;
    }

    @Override
    public String remove(int index) throws TheArgumentIsIargerThanTheArraySizeException {
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("элемент выходит за пределы списка");
        } else {
            for (int i = index; i < size; i++) {
                string[i] = string[i + 1];
            }
            return string[index];
        }
    }

    @Override
    public boolean contains(String item) throws TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (string[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) throws TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = 0; i < size; i++) {
            if (string[i].equals(item)) {
                return i;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(String item) throws TheArgumentIsMissingException {
        if (item == null) {
            throw new TheArgumentIsMissingException("значение не было введено");
        }
        for (int i = size - 1; i > 0; i--) {
            if (string[i].equals(item)) {
                return i;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String get(int index) throws TheArgumentIsIargerThanTheArraySizeException {
        if (index > size) {
            throw new TheArgumentIsIargerThanTheArraySizeException("Элемент выходит за рамки списка");
        } else {
            return string[index];
        }
    }

    @Override
    public boolean equals(StringListController[] otherList) throws TheArgumentIsMissingException {
        if (otherList == null) {
            throw new TheArgumentIsMissingException("Значение не было передано");
        } else {
            for (int i = 0; i < size; i++) {
                if (string[i].equals(otherList[i])) {
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
        if (string[1] == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(string, size);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            string[i] = null;
        }
    }
}
