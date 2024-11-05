import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Работа с именами
        System.out.println("Введите Фамилию, Имя и Отчество через пробел: ");
        String[] nameParts;
        Name customName;
        
        while (true) {
            String inputName = scanner.nextLine().trim();
            if (inputName.isEmpty()) {
                System.out.println("Ошибка: введите Фамилию, Имя и Отчество через пробел:");
                continue;
            }
            nameParts = inputName.split(" ");
            break;
        }

        switch (nameParts.length) {
            case 3:
                customName = new Name(nameParts[0], nameParts[1], nameParts[2]);
                break;
            case 2:
                customName = new Name(nameParts[0], nameParts[1]);
                break;
            case 1:
                customName = new Name(nameParts[0]);
                break;
            default:
                customName = new Name("");
                break;
        }

        System.out.println("\nСозданное имя:");
        System.out.println(customName);

        // Задача со временем
        System.out.println("\nВведите количество секунд с начала суток: ");
        Time timeFromSeconds;
        while (true) {
            try {
                int seconds = Integer.parseInt(scanner.nextLine());
                if (seconds < 0) {
                    System.out.println("Ошибка: введите неотрицательное число секунд.");
                    continue;
                }
                timeFromSeconds = new Time(seconds);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число секунд.");
            }
        }
        System.out.println("\nТекущее время из секунд:");
        System.out.println(timeFromSeconds);

        Time customTime;
        System.out.println("\nВведите (часы, минуты, секунды) или введите количество секунд: ");
        String input = scanner.nextLine();

        if (input.contains(" ")) {
            String[] timeParts = input.split(" ");
            if (timeParts.length == 3) {
                try {
                    int hours = Integer.parseInt(timeParts[0]);
                    int minutes = Integer.parseInt(timeParts[1]);
                    int seconds = Integer.parseInt(timeParts[2]);
                    if (hours < 0 || minutes < 0 || seconds < 0) {
                        System.out.println("Ошибка: введите неотрицательные значения для часов, минут и секунд.");
                        scanner.close();
                        return;
                    }
                    customTime = new Time(hours, minutes, seconds);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректные числа для часов, минут и секунд.");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("Ошибка: необходимо ввести три значения - часы, минуты и секунды.");
                scanner.close();
                return;
            }
        } else {
            try {
                int seconds = Integer.parseInt(input);
                if (seconds < 0) {
                    System.out.println("Ошибка: введите неотрицательное число секунд.");
                    scanner.close();
                    return;
                }
                customTime = new Time(seconds);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число секунд.");
                scanner.close();
                return;
            }
        }

        System.out.println("\nТекущее время:");
        System.out.println(customTime);

        // Задача с сотрудниками и отделами
        System.out.println("\nВведите имена сотрудников через пробел: ");
        String[] employeeNames;
        while (true) {
            String inputEmployees = scanner.nextLine().trim();
            if (inputEmployees.isEmpty()) {
                System.out.println("Ошибка: введите хотя бы одно имя сотрудника.");
                continue;
            }
            employeeNames = inputEmployees.split(" ");
            break;
        }

        Department itDepartment = new Department("IT");

        for (String employeeName : employeeNames) {
            new Employee(employeeName, itDepartment);
        }

        // Ввод имени начальника
        Employee boss = null;
        while (boss == null) {
            System.out.println("\nВведите имя начальника отдела: ");
            String bossNameInput = scanner.nextLine();

            for (Employee employee : itDepartment.getEmployees()) {
                if (employee.getName().equalsIgnoreCase(bossNameInput)) {
                    boss = employee;
                    itDepartment.setBoss(boss);
                    break;
                }
            }

            if (boss == null) {
                System.out.println("Ошибка: сотрудник с именем " + bossNameInput + " не найден. Пожалуйста, введите имя корректно.");
            }
        }

        for (Employee employee : itDepartment.getEmployees()) {
            if (!employee.equals(boss)) {
                employee.setBoss(boss);
            }
        }

        System.out.println("\nСотрудники отдела IT:");
        for (Employee employee : itDepartment.getEmployees()) {
            System.out.println(employee);
        }

        System.out.println("\nВведите имя сотрудника, чтобы получить список всех сотрудников его отдела: ");
        String employeeNameForDepartment = scanner.nextLine();

        for (Employee employee : itDepartment.getEmployees()) {
            if (employee.getName().equalsIgnoreCase(employeeNameForDepartment)) {
                System.out.println("\nСписок всех сотрудников отдела " + itDepartment.getName() + ":");
                for (Employee e : itDepartment.getEmployees()) {
                    System.out.println(e);
                }
                break;
            }
        }

        scanner.close();
    }
}
