package MidExamPreparation.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public String getName() {
        return name;
    }

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();


    }
    public void addEmployee(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }
    public boolean removeEmployee(String name) {
        for (Employee em : employees) {
            if (em.getName().equals(name)) {
                employees.remove(em);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }
    public Employee getEmployee(String name) {
        return this.employees.stream().filter(em -> em.getName().equals(name))
                .findFirst().orElse(null);
    }
    public int getCount() {
        return this.employees.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe " + getName() + ":");
        for (Employee em : employees) {
            sb.append(System.lineSeparator());
            sb.append(em);
        }
        return sb.toString();
    }
}
