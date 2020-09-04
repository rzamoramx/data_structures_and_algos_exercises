package data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stack<T> {
    private List<T> data = new ArrayList<>();

    public List<T> interlace(List<T> s) {
        if (data.isEmpty())
            return s;
        else if (s.isEmpty())
            return data;

        List<T> ma  = (data.size() > s.size())? data: s;
        List<T> mi  = (data.size() <= s.size())? data: s;

        data = new ArrayList<>();
        int idx = 0;
        for (T elem: ma) {
            data.add(elem);
            if (mi.size() >= idx)
                data.add(mi.get(idx));
            idx++;
        }

        ma = null;
        mi = null;
        return data;
    }

    public List<T> concat(List<T> s) {
        throwEmptyException();

        data.addAll(s);

        return data;
    }

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

    public List<T> inverse() {
        throwEmptyException();

        if (data.size()==1)
            return data;

        Collections.reverse(data);
        return data;
    }

    public T bottom() {
        throwEmptyException();

        return data.get(0);
    }

    public int size() {
        return data.size();
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

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void throwEmptyException() {
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
    }
}
