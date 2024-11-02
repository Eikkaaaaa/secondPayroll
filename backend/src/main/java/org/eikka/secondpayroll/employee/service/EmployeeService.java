package org.eikka.secondpayroll.employee.service;

import org.eikka.secondpayroll.employee.model.Employee;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    CollectionModel<EntityModel<Employee>> All();
    EntityModel<Employee> create(Employee employee);
    EntityModel<Employee> one(Long id);
    EntityModel<Employee> update(Long id, Employee newEmployee);
    ResponseEntity<Void> delete(Long id);
}
