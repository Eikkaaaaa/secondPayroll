package org.eikka.secondpayroll.employee.service;

import org.eikka.secondpayroll.employee.model.Employee;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.IanaLinkRelations;

import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Fetches all employee instances from the database.
     * @return {@link CollectionModel} of {@link EntityModel<Employee>} instances
     */
    @GetMapping
    public CollectionModel<EntityModel<Employee>> all() {

        return employeeService.All();
    }

    /**
     * Creates a new employee instance.
     * @param employee The {@link Employee} data to be created
     * @return ResponseEntity with the created employee model
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {

        EntityModel<Employee> employeeModel = employeeService.create(employee);
        return ResponseEntity.created(employeeModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(employeeModel);
    }

    /**
     * Retrieves a single employee by ID.
     * @param id Employee ID
     * @return EntityModel of the employee
     */
    @GetMapping("/{id}")
    public EntityModel<Employee> one(@PathVariable Long id) {

        return employeeService.one(id);
    }

    /**
     * Updates an employee with the provided data.
     * @param id Employee ID
     * @param newEmployee Employee data for the update
     * @return ResponseEntity with the updated employee model
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee newEmployee) {

        EntityModel<Employee> employeeModel = employeeService.update(id, newEmployee);
        return ResponseEntity.ok(employeeModel);
    }

    /**
     * Deletes an employee by ID.
     * @param id Employee ID
     * @return NoContent response if successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
