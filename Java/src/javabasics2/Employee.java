// Implementing basic concepts of Java: data, variable and modifier types, constructors.

package javabasics2;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private final String employeeId;
    private static int employeeCount = 0;

    // Constructor with all parameters
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.employeeId = "E" + (++employeeCount);
    }

    // Constructor with default salary
    public Employee(String name, int age) {
        // Call the other constructor with default salary of Rs 50000.0
        this(name, age, 50000.0);
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        // Creating employees using both constructors
        Employee employee1 = new Employee("Rohan Reddy", 21, 100000.0);
        Employee employee2 = new Employee("Monish Gopi", 23);

        // Displaying employee information
        System.out.println("Employee 1 Information:");
        employee1.displayInfo();

        System.out.println("\nEmployee 2 Information:");
        employee2.displayInfo();
    }
}
