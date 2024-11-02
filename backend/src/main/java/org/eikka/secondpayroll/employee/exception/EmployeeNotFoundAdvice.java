package org.eikka.secondpayroll.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // signals that this advice is rendered straight into the response body
public class EmployeeNotFoundAdvice {

    /**
     * When {@link EmployeeNotFoundException} is thrown, this is used to render it as a 404 error
     * @param e {@link EmployeeNotFoundException}
     * @return String, which is the message contained in the EmployeeNotFoundException instance
     */
    @ExceptionHandler(EmployeeNotFoundException.class)  //configures the advice to only respond when an EmployeeNotFoundException is thrown.
    @ResponseStatus(HttpStatus.NOT_FOUND)   //  says to issue an HttpStatus.NOT_FOUND - that is, an HTTP 404 error.
    public String employeeNotHandler(EmployeeNotFoundException e) {
        return e.getMessage();
    }
}
