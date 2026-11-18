
import java.util.*;
import java.io.*;

class Employee {

    int employeeId;
    String employeeName;
    String department;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.employeeId = id;
        this.employeeName = name;
        this.department = dept;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-----------------------------");
    }
}

public class EmployeeManagementSystem {

    static HashMap<Integer, Employee> employees = new HashMap<>();
    static BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            String input = br.readLine();

            if (input == null) {
                System.out.println("Input closed. Exiting program.");
                break;
            }

            int choice;

            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    updateEmployee();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    displayAllEmployees();
                    break;

                case 5:
                    searchEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    return;

                default:
                    System.out.println("Invalid choice! Enter 1 to 6.");
            }
        }
    }

    // Add Employee
    static void addEmployee() throws IOException {

        int id = readInt("Enter Employee ID: ");

        if (employees.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = br.readLine();

        System.out.print("Enter Department: ");
        String dept = br.readLine();

        double salary = readDouble("Enter Salary: ");

        employees.put(id, new Employee(id, name, dept, salary));

        System.out.println("Employee added successfully!");
    }

    // Update Employee
    static void updateEmployee() throws IOException {

        int id = readInt("Enter Employee ID to update: ");

        Employee emp = employees.get(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter New Employee Name: ");
        emp.employeeName = br.readLine();

        System.out.print("Enter New Department: ");
        emp.department = br.readLine();

        emp.salary = readDouble("Enter New Salary: ");

        System.out.println("Employee updated successfully!");
    }

    // Delete Employee
    static void deleteEmployee() throws IOException {

        int id = readInt("Enter Employee ID to delete: ");

        if (employees.remove(id) != null) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Display All Employees
    static void displayAllEmployees() {

        System.out.println("\n===== ALL EMPLOYEE DETAILS =====");

        if (employees.isEmpty()) {
            System.out.println("No employee records available!");
            return;
        }

        for (Employee emp : employees.values()) {
            emp.displayDetails();
        }

        System.out.println("Total Employees: " + employees.size());
    }

    // Search Employee
    static void searchEmployee() throws IOException {

        int id = readInt("Enter Employee ID to search: ");

        Employee emp = employees.get(id);

        if (emp == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("\n===== EMPLOYEE FOUND =====");
            emp.displayDetails();
        }
    }

    // Read Integer
    static int readInt(String message) throws IOException {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(br.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    // Read Double
    static double readDouble(String message) throws IOException {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(br.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid salary!");
            }
        }
    }
}
