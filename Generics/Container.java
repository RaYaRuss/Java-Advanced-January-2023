package Generics;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {

    private List<T> items;

    public void addItem (T item) {
        this.items.add(item);
    }

    public Container() {
        this.items = new ArrayList<>();
    }
    public boolean removeItem(T item) {
        return this.items.remove(item);
    }

}
