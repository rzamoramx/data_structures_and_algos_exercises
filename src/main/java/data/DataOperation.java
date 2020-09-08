package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class DataOperation<T> {
    protected List<T> data = new ArrayList<>();

    public void empty() {
        data = new ArrayList<>();
    }

    // TODO maybe improve performance with linked list
    public List<T> interlace(List<T> list2) {
        ListIterator<T> it1 = data.listIterator();
        ListIterator<T> it2 = list2.listIterator();

        data = new ArrayList<>();

        while (it1.hasNext() && it2.hasNext()) {
            data.add(it1.next());
            data.add(it2.next());
        }

        while (it1.hasNext()) {
            data.add(it1.next());
        }

        while (it2.hasNext()) {
            data.add(it2.next());
        }

        it1 = null; it2 = null;
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
