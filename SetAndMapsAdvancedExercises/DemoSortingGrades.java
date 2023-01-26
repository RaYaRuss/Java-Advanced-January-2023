package SetAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DemoSortingGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new HashMap<>();

        // Първи случай: descending order
        // сортираме по най-голям брой оценки на дедени студенти с оценки
        // пешо - 4,5,6,7
        // иван - 4,5,6,6,3,4,5,
        // петя - 5,6,4
        studentsGrade.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size()) // вече сортиран мап - ако искаме отпечатваме
                .forEach(е -> System.out.println());
        // s1 i s2 - студент 1 и студент 2
        // sorted - >размества записите на базата на цяло число, което се получава при сравнение
        //sorted -> > 0 -> razmenq zapisite
        //sorted -< <= 0 -> ne razmenq zapisite

        // Втори случай : ученик с най-малък брой стиденти - ascending order спрямо брой оценки
        studentsGrade.entrySet().stream()
                .sorted((s1, s2) -> s1.getValue().size() - s2.getValue().size());

    }
}
