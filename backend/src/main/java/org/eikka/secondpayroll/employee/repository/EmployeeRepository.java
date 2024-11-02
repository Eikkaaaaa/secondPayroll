package org.eikka.secondpayroll.employee.repository;

import org.eikka.secondpayroll.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin // TODO This can be removed later
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
