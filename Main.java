import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Работа с именами
        System.out.println("Введите Фамилию, Имя и Отчество через пробел: ");
        String[] nameParts = scanner.nextLine().split(" ");
        Name customName;

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
                customName = new Name(""); // В случае пустого ввода
                break;
        }

        System.out.println("\nСозданное имя:");
        System.out.println(customName);

        // Работа со временем: вводим количество секунд с начала суток
        System.out.println("\nВведите количество секунд с начала суток: ");
        Time timeFromSeconds;
        while (true) {
            try {
                timeFromSeconds = new Time(Integer.parseInt(scanner.nextLine()));
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
                    customTime = new Time(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]), Integer.parseInt(timeParts[2]));
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
                customTime = new Time(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число секунд.");
                scanner.close();
                return;
            }
        }

        System.out.println("\nТекущее время:");
        System.out.println(customTime);

        // Информация о времени
        System.out.println("Час: " + customTime.getHours());
        System.out.println("Минуты: " + customTime.getMinutes());
        System.out.println("Секунды: " + customTime.getSeconds());

        // Дополнительные задания по времени
        System.out.println("\nВывод времени в различных единицах:");
        
        System.out.println("Введите количество секунд для преобразования в часы: ");
        int secondsForHours = Integer.parseInt(scanner.nextLine());
        System.out.println(secondsForHours + " секунд соответствуют " + (secondsForHours / 3600) + " часам.");

        System.out.println("Введите количество секунд для преобразования в минуты: ");
        int secondsForMinutes = Integer.parseInt(scanner.nextLine());
        System.out.println(secondsForMinutes + " секунд соответствуют " + (secondsForMinutes / 60) + " минутам.");

        System.out.println("Введите количество секунд для преобразования в секунды: ");
        int secondsForSeconds = Integer.parseInt(scanner.nextLine());
        System.out.println(secondsForSeconds + " секунд соответствуют " + secondsForSeconds + " секундам.");

        // Работа с сотрудниками и отделами
        System.out.println("\nВведите имена сотрудников через пробел: ");
        String[] employeeNames = scanner.nextLine().split(" ");
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

        // Закрываем сканер
        scanner.close();
    }
}
