import Exceptions.TheArgumentIsIargerThanTheArraySizeException;
import Exceptions.TheArgumentIsMissingException;
import Exceptions.TheArgumentIsMissingFromTheListException;

public interface StringListInt {
    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(int item) throws TheArgumentIsMissingException;

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(int index, int item) throws TheArgumentIsMissingException;

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    Integer set(int index, int item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException;

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer remove(int item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException, TheArgumentIsMissingFromTheListException;

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer removeIndex(int index) throws TheArgumentIsIargerThanTheArraySizeException;

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(Integer item) throws TheArgumentIsIargerThanTheArraySizeException, TheArgumentIsMissingException, TheArgumentIsMissingFromTheListException;

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(Integer item) throws TheArgumentIsMissingException;

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(Integer item) throws TheArgumentIsMissingException;

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    Integer get(int index) throws TheArgumentIsIargerThanTheArraySizeException;

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(StringListController[] otherList) throws TheArgumentIsMissingException;

    // Вернуть фактическое количество элементов.
    int size();

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty();

    // Удалить все элементы из списка.
    void clear();

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    Integer[] toArray();
}
