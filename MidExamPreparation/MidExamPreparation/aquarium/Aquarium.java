package MidExamPreparation.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size; // (the volume of the pool)
   private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        int number = getFishInPool();
        if (number < this.capacity) {
            this.fishInPool.add(fish);
        }
//        if (number == 0) {
//            this.fishInPool.add(fish);
//        } else if (number < this.capacity) {
//            for (Fish f : fishInPool) {
//                if (!f.getName().equals(fish.getName())) {
//                    this.fishInPool.add(fish);
//                }
//            }
//        }
        }
    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
            return false;
        }
    public Fish findFish(String name) {
       return fishInPool.stream().filter(f -> f.getName().equals(name)).findAny().orElse(null);
    }
    public String report() {
        StringBuilder builder = new StringBuilder();
        String output = String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize());
        builder.append(output);
        for (Fish f : fishInPool) {
            builder.append(System.lineSeparator());
            builder.append(f);
        }
        return builder.toString();
    }
}
