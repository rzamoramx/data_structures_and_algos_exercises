package data.structures;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<String> data = new ArrayList<>();

    public List<String> pop() {
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("the stack is empty");

        data.remove(data.size()-1);
        return data;
    }

    public List<String> push(String elem) {
        data.add(elem);
        return data;
    }

    public String top() {
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("the stack is empty");

        return data.get(data.size()-1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
