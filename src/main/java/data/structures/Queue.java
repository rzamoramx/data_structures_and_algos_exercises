package data.structures;

import java.util.List;

public class Queue<T> {
    List<T> data;

    public List<T> turn(T elem) {
        data.add(elem);
        return data;
    }

    public T forward() {
        throwEmptyException();

        T elem = data.get(0);
        data.remove(0);

        return elem;
    }

    public T first() {
        throwEmptyException();

        return data.get(data.size()-1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void throwEmptyException() {
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
    }
}
