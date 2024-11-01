package org.eikka.secondpayroll.employee.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * This class is to represent a single Employee entity in the database. The class in instantiated using normal Getters and Setters instead of {@code Lombok @Annotations} because for some reason the program doesen't compile with lombok.
 */
@Entity
public class Employee extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String created;
    private String modified;
    private String mailDomain;

    public Employee() {}

    /**
     * The constructor for an Employee to be added
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     * @param email the email address of the person
     * @param phone the phone number of the person
     */
    public Employee(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        setEmail(email);
    }

    /**
     * Formats the time and date of creation really neatly
     */
    @PrePersist
    protected void onCreate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String now = formatter.format(new Date());
        this.created = now;
        this.modified = now;
    }

    /**
     * Adds the email to each user automatically upon instantiation, and also adds the mail domain to the person
     * @param email The email {@link String} that is the email and contains the domain as well
     */
    public void setEmail(String email) {
        this.email = email;
        setMailDomain(email);
    }

    /**
     * Picks the domain from the email
     * @param email string that is parsed. Picks everything after the "@" and adds it to the domain upon addition
     */
    public void setMailDomain(String email) {
        if (email != null && email.contains("@")) {
            this.mailDomain = email.substring(email.indexOf("@"));
        } else {
            this.mailDomain = "";
        }
    }

    public String getMailDomain() {
        return mailDomain;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getEmployeeId(){
        return super.getId();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), firstName, lastName, email, phone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getEmployeeId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
