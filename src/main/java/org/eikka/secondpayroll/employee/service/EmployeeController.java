package org.eikka.secondpayroll.employee.service;

import org.eikka.secondpayroll.employee.exception.EmployeeNotFoundException;
import org.eikka.secondpayroll.employee.model.Employee;
import org.eikka.secondpayroll.employee.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Returns all employees from the database
     * @return {@link Employee} list
     */
    @GetMapping
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee one(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee newEmployee) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String now = formatter.format(new Date());

        return employeeRepository.findById(id)
                .map(employee -> {
                    if (newEmployee.getFirstName() != null) {
                        employee.setFirstName(newEmployee.getFirstName());
                    }
                    if (newEmployee.getLastName() != null) {
                        employee.setLastName(newEmployee.getLastName());
                    }
                    if (newEmployee.getEmail() != null) {
                        employee.setEmail(newEmployee.getEmail());
                    }
                    if (newEmployee.getPhone() != null) {
                        employee.setPhone(newEmployee.getPhone());
                    }

                    employee.setModified(now);
                    return employeeRepository.save(employee);
                }).orElseGet(() -> employeeRepository.save(newEmployee));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
