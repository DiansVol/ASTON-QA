public class Zad1 {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Иван Иванов", "Менеджер", "ivan.ivanov@company.com", "89123456789", 50000, 30);
        Employee employee2 = new Employee("Мария Петрова", "Разработчик", "maria.petrova@company.com", "89876543210", 80000, 25);
        employee1.printInfo();
        System.out.println("-----------------------");
        employee2.printInfo();
    }
}
class Employee {
    String fullName;
    String position;
    String email;
    String phone;
    double salary;
    int age;
    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}
