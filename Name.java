public class Name {
    // Поля
    private String lastName;
    private String firstName;
    private String middleName;

    // Конструкторы
    public Name(String lastName) {
        this(lastName, "", "");
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, "");
    }

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Свойство
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!lastName.isEmpty()) sb.append(lastName);
        if (!firstName.isEmpty()) sb.append(" ").append(firstName);
        if (!middleName.isEmpty()) sb.append(" ").append(middleName);
        return sb.toString().trim();
    }
}
