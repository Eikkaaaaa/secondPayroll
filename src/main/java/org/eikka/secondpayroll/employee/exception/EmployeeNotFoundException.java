package org.eikka.secondpayroll.employee.exception;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with the ID: " + id + " was not found.");
    }
}
