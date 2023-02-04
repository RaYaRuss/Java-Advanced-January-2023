package Generics;

import java.util.HashMap;
import java.util.Map;

public class MapContainer<K, V> {

    private Map<K, V> data;

    public MapContainer() {
        this.data = new HashMap<>();
    }

    public void addItem(K key, V value) {
        this.data.put(key, value);
    }

    public boolean removeItem(K key, V value) {
      return this.data.remove(key, value);
    }
}
