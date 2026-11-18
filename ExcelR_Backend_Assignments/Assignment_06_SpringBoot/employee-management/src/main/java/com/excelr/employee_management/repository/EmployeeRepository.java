
package com.excelr.employee_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.employee_management.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
