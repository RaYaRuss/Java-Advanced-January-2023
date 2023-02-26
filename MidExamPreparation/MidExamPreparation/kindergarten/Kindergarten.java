package MidExamPreparation.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
           return registry.add(child);
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child ch : registry) {
            if (ch.getFirstName().equals(firstName)) {
                return registry.remove(ch);
            }
        }
        return false;
    }
    public int getChildrenCount() {
        return this.registry.size();
    }
    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }


    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        String output = String.format("Registered children in %s:", this.name);
        sb.append(output);

        this.registry.stream().sorted(Comparator.comparingInt(Child::getAge)
                        .thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .forEach(ch -> sb.append(System.lineSeparator()).append("--").append(System.lineSeparator()).append(ch));

        return sb.toString();
    }
}
