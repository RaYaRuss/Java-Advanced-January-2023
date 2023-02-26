package MidExamPreparation.groomingSalon;
import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }
    public Pet getPet(String name, String owner) {
        for (Pet p : data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                return p;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(pet.getName() + " " + pet.getOwner());
        }
        return sb.toString();
    }
}
