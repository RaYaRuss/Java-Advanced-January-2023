package MidExamPreparation.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle) {
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                exercises.remove(ex);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle) {
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                return ex;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise() {
        //return Collections.max(exercises, Comparator.comparingInt(Exercise::getBurnedCalories));
        return exercises.stream()
                .max(Comparator.comparingInt(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public int getExerciseCount() {
        return exerciseCount;
    }
    public String getStatistics() {
        String first = String.format("Workout type: %s", this.type);
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for (Exercise ex : exercises) {
            sb.append(System.lineSeparator());
            sb.append(ex);
        }
        return sb.toString();
    }
}
