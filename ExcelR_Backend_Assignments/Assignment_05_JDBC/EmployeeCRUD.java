
import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

    static final String URL =
        "jdbc:mysql://localhost:3306/employee_management";

    static final String USER = "root";

    // Enter your own MySQL password here
    static final String PASSWORD = "Anitha@123";

    static Scanner sc = new Scanner(System.in);
    static Connection con;

    public static void main(String[] args) {

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            while (true) {

                System.out.println("\n===== EMPLOYEE CRUD SYSTEM =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6. Exit");

                int choice = readInt("Enter your choice: ");

                switch (choice) {

                    case 1:
                        addEmployee();
                        break;

                    case 2:
                        displayEmployees();
                        break;

                    case 3:
                        searchEmployee();
                        break;

                    case 4:
                        updateEmployee();
                        break;

                    case 5:
                        deleteEmployee();
                        break;

                    case 6:
                        System.out.println("Thank you!");
                        con.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Enter 1 to 6.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());

        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection.");
            }
        }
    }

    // Read integer safely
    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Read salary safely
    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double salary = Double.parseDouble(sc.nextLine().trim());

                if (salary < 0) {
                    System.out.println("Salary cannot be negative!");
                    continue;
                }

                return salary;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid salary!");
            }
        }
    }

    // 1. Add Employee
    static void addEmployee() {

        try {
            int id = readInt("Enter Employee ID: ");

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            double salary = readDouble("Enter Salary: ");

            String sql = "INSERT INTO employees VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, department);
                ps.setDouble(4, salary);

                ps.executeUpdate();

                System.out.println("Employee added successfully!");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Employee ID already exists!");

        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // 2. Display All Employees
    static void displayEmployees() {

        String sql = "SELECT * FROM employees";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n===== ALL EMPLOYEE DETAILS =====");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Employee ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("-----------------------------");
            }

            if (!found) {
                System.out.println("No employee records found!");
            }

        } catch (SQLException e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        }
    }

    // 3. Search Employee
    static void searchEmployee() {

        int id = readInt("Enter Employee ID to search: ");

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\n===== EMPLOYEE FOUND =====");
                    System.out.println("Employee ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Salary: " + rs.getDouble("salary"));

                } else {
                    System.out.println("Employee not found!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    }

    // 4. Update Employee
    static void updateEmployee() {

        int id = readInt("Enter Employee ID to update: ");

        System.out.print("Enter New Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Department: ");
        String department = sc.nextLine();

        double salary = readDouble("Enter New Salary: ");

        String sql =
            "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    // 5. Delete Employee
    static void deleteEmployee() {

        int id = readInt("Enter Employee ID to delete: ");

        String sql = "DELETE FROM employees WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}
