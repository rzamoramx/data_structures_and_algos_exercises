package data.structures;

import data.DataOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> extends DataOperation<T> {
    public List<T> dup() {
        throwEmptyException();

        List<T> tmp = new ArrayList<>();
        for (T elem: data) {
            tmp.add(elem);
            tmp.add(elem);
        }
        data = tmp;

        tmp = null;
        return data;
    }

    public T bottom() {
        throwEmptyException();

        return data.get(0);
    }

    public List<T> pop() {
        throwEmptyException();

        data.remove(data.size()-1);
        return data;
    }

    public List<T> push(T elem) {
        data.add(elem);
        return data;
    }

    public T top() {
        throwEmptyException();

        return data.get(data.size()-1);
    }

    public int getIndexTop() {
        return data.size()-1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "data=" + Arrays.toString(data.toArray()) +
                '}';
    }
}
