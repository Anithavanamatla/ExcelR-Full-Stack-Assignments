
package com.excelr.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.employee_management.Employee;
import com.excelr.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 1. Add Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // 2. Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // 3. Get Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

        Optional<Employee> employee = employeeService.getEmployeeById(id);

        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    // 5. Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
