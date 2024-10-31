package org.eikka.secondpayroll;

import org.eikka.secondpayroll.employee.model.Employee;
import org.eikka.secondpayroll.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            logger.info("Preloading Employee: {}", repository.save(new Employee("Einar", "Helkkula", "eikka@sposti.com", "0401234567")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Johanna", "Saari", "johanna@sposti.com", "0409876541")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Jonathan", "Uu-Vee", "Jonathan@poliisi.fi", "040123577")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Osku", "Tarkkila", "Osku@kk.com", "0450690567")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Kia", "Koo", "Kia@akademi.com", "04017864567")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Vertsi", "Helkkula", "Vertsi@sposti.com", "040786757")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Allu", "Helkkula", "Allu@sposti.com", "04076876")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("John", "Doe", "Johnny@mail.com", "04076876")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Alice", "Smith", "alice.smith@mail.com", "0401234567")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Bob", "Johnson", "bob.johnson@mail.com", "0402345678")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Charlie", "Brown", "charlie.brown@mail.com", "0403456789")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Daisy", "Miller", "daisy.miller@mail.com", "0404567890")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Ethan", "Taylor", "ethan.taylor@mail.com", "0405678901")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Fiona", "Wilson", "fiona.wilson@mail.com", "0406789012")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("George", "Moore", "george.moore@mail.com", "0407890123")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Hannah", "Thomas", "hannah.thomas@mail.com", "0408901234")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Ian", "Jackson", "ian.jackson@mail.com", "0409012345")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Julia", "White", "julia.white@mail.com", "0400123456")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Kevin", "Harris", "kevin.harris@mail.com", "0401234561")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Lily", "Martin", "lily.martin@mail.com", "0402345672")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Michael", "Garcia", "michael.garcia@mail.com", "0403456783")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Nina", "Martinez", "nina.martinez@mail.com", "0404567894")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Oscar", "Rodriguez", "oscar.rodriguez@mail.com", "0405678905")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Paula", "Martinez", "paula.martinez@mail.com", "0406789016")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Quinn", "Clark", "quinn.clark@mail.com", "0407890127")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Rachel", "Lopez", "rachel.lopez@mail.com", "0408901238")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Samuel", "Gonzalez", "samuel.gonzalez@mail.com", "0409012349")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Tina", "Hill", "tina.hill@mail.com", "0400123457")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Ursula", "Scott", "ursula.scott@mail.com", "0401234568")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Victor", "Green", "victor.green@mail.com", "0402345679")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Wendy", "Baker", "wendy.baker@mail.com", "0403456780")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Xander", "Perez", "xander.perez@mail.com", "0404567891")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Yara", "Sanchez", "yara.sanchez@mail.com", "0405678902")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Zane", "King", "zane.king@mail.com", "0406789013")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Abigail", "Murphy", "abigail.murphy@mail.com", "0407890124")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Brian", "Rivera", "brian.rivera@mail.com", "0408901235")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Claire", "Howard", "claire.howard@mail.com", "0409012346")));
            logger.info("Preloading Employee: {}", repository.save(new Employee("Dylan", "Wright", "dylan.wright@mail.com", "0400123458")));
        };
    }
}