package org.eikka.secondpayroll.employee.service;

import org.eikka.secondpayroll.employee.exception.EmployeeNotFoundException;
import org.eikka.secondpayroll.employee.model.Employee;
import org.eikka.secondpayroll.employee.repository.EmployeeRepository;
import org.eikka.secondpayroll.employee.utility.EmployeeModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Service class to do {@code CRUD} operations on an Employee database
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeModelAssembler assembler;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeModelAssembler employeeModelAssembler) {
        this.repository = employeeRepository;
        this.assembler = employeeModelAssembler;
    }

    /**
     * Fetches all Employees listed in the database
     * @return {@link CollectionModel} which is a collection of {@link EntityModel<Employee>} instances in the db
     */
    @Override
    public CollectionModel<EntityModel<Employee>> All() {

        List<EntityModel<Employee>> employees = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    /**
     * Creates a single instance of an employee to the db. Creates an {@link EntityModel} from a single {@link Employee} class
     * @param employee The {@link Employee} class of which the instance is to be created of
     * @return {@link EntityModel} of the given {@link Employee} instance
     */
    @Override
    public EntityModel<Employee> create(Employee employee) {

        Employee savedEmployee = repository.save(employee);
        return assembler.toModel(savedEmployee);
    }

    /**
     * Returns a single instance of an Employee Entity model
     * @param id Takes the id of an Employee to search
     * @return if found, returns an {@link EntityModel} of it
     */
    @Override
    public EntityModel<Employee> one(Long id) {

        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return assembler.toModel(employee);
    }
    /**
     * Used to update a given Employee instance in the db, and if found, only the given parameters are updates and the {@code modified} attribute of the instance is updated
     * @param id The id of the Employee to be updated
     * @param newEmployee The contents that shall be updated for the searched employee
     * @return Updated Entity model of the Employee
     */
    @Override
    public EntityModel<Employee> update(Long id, Employee newEmployee) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        Employee employee = repository.findById(id).map(emp -> {
            if (newEmployee.getFirstName() != null && !newEmployee.getFirstName().equals(emp.getFirstName())) {
                emp.setFirstName(newEmployee.getFirstName());
            }
            if (newEmployee.getLastName() != null && !newEmployee.getLastName().equals(emp.getLastName())) {
                emp.setLastName(newEmployee.getLastName());
            }
            if (newEmployee.getEmail() != null && !newEmployee.getEmail().equals(emp.getEmail())) {
                emp.setEmail(newEmployee.getEmail());
            }
            if (newEmployee.getPhone() != null && !newEmployee.getPhone().equals(emp.getPhone())) {
                emp.setPhone(newEmployee.getPhone());
            }
            emp.setModified(formatter.format(new Date()));
            return repository.save(emp);
        }).orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toModel(employee);
    }

    /**
     * If found, deletes the instance from the db
     *
     * @param id The id of the employee to be deleted
     * @return {@code true} if the deletion was successful
     */
    @Override
    public ResponseEntity<Void> delete(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        repository.delete(employee);
        return ResponseEntity.noContent().build();
    }
}
