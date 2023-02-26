package MidExamPreparation.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }
    public boolean remove(String name) {

        return data.removeIf(e -> e.getName().equals(name));
    }
    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findAny()
                .orElse(null);
    }
    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).get();
        //return Collections.max(data, Comparator.comparing(Elephant::getAge));
    }
    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : this.data){
            sb.append(elephant.getName()).append(" came from: ")
                    .append(elephant.getRetiredFrom()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

