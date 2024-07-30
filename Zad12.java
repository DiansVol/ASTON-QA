public class Zad12 {

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) {
        int yearToCheck = 2024; // Example year
        boolean isLeap = isLeapYear(yearToCheck);
        System.out.println(yearToCheck + " is a leap year: " + isLeap);
    }
}
