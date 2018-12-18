package com.behzad.spring.reactive.app;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        if (employeeService.findOneByDB(1L) == null) {
            Employee employee = null;
            for (int i = 0; i < 10; i++) {
                employee = new Employee("name" + i, "john" + i + "@gmail.com");
                employeeService.save(employee);
            }
        }

    }
}
