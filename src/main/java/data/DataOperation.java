package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataOperation<T> {
    protected List<T> data = new ArrayList<>();

    public void empty() {
        data = new ArrayList<>();
    }

    public List<T> interlace(List<T> s) {
        data
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

    public List<T> inverse() {
        throwEmptyException();

        if (data.size()==1)
            return data;

        Collections.reverse(data);
        return data;
    }

    public List<T> copy() {
        throwEmptyException();

        List<T> tmp = new ArrayList<>();
        Collections.copy(tmp, data);

        return tmp;
    }

    public List<T> concat(List<T> queue) {
        throwEmptyException();

        data.addAll(queue);

        return data;
    }

    protected void throwEmptyException() {
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("the data is empty");
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
