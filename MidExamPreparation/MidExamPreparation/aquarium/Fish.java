package MidExamPreparation.aquarium;

public class Fish {

    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineOne = String.format("Fish: %s", getName());
        sb.append(lineOne).append(System.lineSeparator());
        String lineTwo = String.format("Color: %s", getColor());
        sb.append(lineTwo).append(System.lineSeparator());
        String lineThree = String.format("Number of fins: %d", getFins());
        sb.append(lineThree);
        return sb.toString();
    }
}
