package org.eikka.secondpayroll.employee.utility;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import lombok.NonNull;
import org.eikka.secondpayroll.employee.model.Employee;
import org.eikka.secondpayroll.employee.service.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {


    /**
     * Converts an instance of an {@link Employee} ("non-model object") to an {@link EntityModel<Employee>} object
     * <ul>
     *     <li>{@code linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel()} asks that Spring HATEOAS build a link to the one method of EmployeeController and flag it as a self link.</li>
     *     <li>{@code linkTo(methodOn(EmployeeController.class).all()).withRel("employees")} asks Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".</li>
     * </ul>
     * @param emp An instance of {@link Employee} class
     * @return {@link EntityModel<Employee>} instance
     */
    @Override
    @NonNull
    public EntityModel<Employee> toModel(@NonNull Employee emp) {
        return EntityModel.of(emp,
                linkTo(methodOn(EmployeeController.class).one(emp.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}
