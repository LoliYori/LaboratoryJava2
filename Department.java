import java.util.ArrayList;
import java.util.List;

public class Department {
    // Поля
    private String name;
    private Employee boss;
    private List<Employee> employees;

    // Конструкторы
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Свойство
    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Метод
    public String toString() {
        return "Отдел " + name + ", начальник отдела " + (boss != null ? boss.getName() : "не назначен");
    }
}
