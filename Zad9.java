public class Zad9 {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        int year = 2024;
        boolean isLeap = isLeapYear(year);
        System.out.println(year + " is a leap year: " + isLeap);
    }
}