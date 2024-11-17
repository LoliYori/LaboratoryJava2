public class Time {
    // Поля
    private int seconds;

    // Конструкторы
    public Time(int seconds) {
        this.seconds = seconds % 86400;
    }

    public Time(int hours, int minutes, int seconds) {
        this.seconds = (hours * 3600 + minutes * 60 + seconds) % 86400;
    }

    // Свойство
    public int getHours() {
        return seconds / 3600;
    }

    public int getMinutes() {
        return (seconds % 3600) / 60;
    }

    public int getSeconds() {
        return seconds % 60; 
    }

    // Метод
    public String toString() {
        int hours = getHours();
        int minutes = getMinutes();
        int secs = getSeconds();
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
