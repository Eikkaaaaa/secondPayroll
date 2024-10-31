package org.eikka.secondpayroll.employee.repository;

import org.eikka.secondpayroll.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
