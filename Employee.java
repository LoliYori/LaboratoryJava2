public class Employee {
    private String name;
    private Department department;
    private Employee boss;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        this.boss = null; 
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Department getDepartment() {
        return department;
    }

    public String toString() {
        if (boss == null) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + boss.getName();
        }
    }
}
