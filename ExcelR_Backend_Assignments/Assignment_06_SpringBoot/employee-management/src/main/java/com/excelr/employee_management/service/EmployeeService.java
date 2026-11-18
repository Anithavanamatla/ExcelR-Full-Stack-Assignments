
package com.excelr.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.excelr.employee_management.Employee;
import com.excelr.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // Update Employee
    public Employee updateEmployee(int id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Employee not found with ID: " + id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }

        employeeRepository.deleteById(id);
    }
}
