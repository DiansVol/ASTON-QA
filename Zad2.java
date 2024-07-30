public class Zad2 {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Manager", "ppetrov@mailbox.com", "891234567", 50000, 40);
        persArray[2] = new Person("Sidorov Sergey", "Analyst", "ssidorov@mailbox.com", "898765432", 40000, 35);
        persArray[3] = new Person("Kuznetsova Olga", "Accountant", "okuzova@mailbox.com", "890123456", 35000, 38);
        persArray[4] = new Person("Smirnov Dmitry", "Designer", "dsmirnov@mailbox.com", "897890123", 45000, 32);
        for (Person person : persArray) {
            System.out.println("Имя: " + person.getName());
            System.out.println("Должность: " + person.getPosition());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Телефон: " + person.getPhone());
            System.out.println("Зарплата: " + person.getSalary());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("------------------");
        }
    }
}
class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
}
