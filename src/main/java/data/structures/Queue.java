package data.structures;

import data.DataOperation;

import java.util.List;

public class Queue<T> extends DataOperation<T> {
    public List<T> turn(T elem) {
        data.add(elem);
        return data;
    }

    public T quiteLast() {
        throwEmptyException();

        T elem = data.get(data.size()-1);
        data.remove(data.size()-1);
        return elem;
    }

    public T forward() {
        throwEmptyException();

        T elem = data.get(0);
        data.remove(0);

        return elem;
    }

    public T first() {
        throwEmptyException();

        return data.get(0);
    }

    public T last() {
        throwEmptyException();

        return data.get(data.size()-1);
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "data=" + data +
                '}';
    }
}
