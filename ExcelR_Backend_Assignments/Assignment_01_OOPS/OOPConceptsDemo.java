
interface BonusEligible {
    double calculateBonus();
}

// 2. Abstract Class
abstract class Employee {

    int employeeId;
    String employeeName;
    double basicSalary;

    // 3. Constructor
    Employee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    // Abstract method
    abstract double calculateSalary();

    // Normal method
    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

// 4. Inheritance and Interface Implementation
class FullTimeEmployee extends Employee implements BonusEligible {

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    // 5. Method Overriding
    @Override
    double calculateSalary() {
        return basicSalary + 5000;
    }

    // 6. Interface method implementation
    @Override
    public double calculateBonus() {
        return basicSalary * 0.10;
    }

    // 7. Method Overloading
    double calculateSalary(double allowance) {
        return basicSalary + 5000 + allowance;
    }
}

// Main Class
public class OOPConceptsDemo {

    public static void main(String[] args) {

        // Creating an object
        FullTimeEmployee emp = new FullTimeEmployee(
            101,
            "Anitha Vanamatla",
            30000
        );

        System.out.println("===== EMPLOYEE DETAILS =====");

        emp.displayDetails();

        System.out.println("\n===== SALARY DETAILS =====");

        System.out.println("Total Salary: " + emp.calculateSalary());

        System.out.println("Salary with Allowance: "
                + emp.calculateSalary(2000));

        System.out.println("Employee Bonus: "
                + emp.calculateBonus());

        System.out.println("\n===== OOP CONCEPTS DEMONSTRATED =====");

        System.out.println("Class and Object");
        System.out.println("Constructor");
        System.out.println("Method Overloading");
        System.out.println("Method Overriding");
        System.out.println("Inheritance");
        System.out.println("Interface");
        System.out.println("Abstract Class");

    }
}
