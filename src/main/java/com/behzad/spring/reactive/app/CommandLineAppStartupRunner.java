package com.behzad.spring.reactive.app;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeService.count()
                .filter(count -> count == 0)
                .subscribe(count -> {
//                    createSomeEmployees();
                });

    }

    private void createSomeEmployees() {
        Employee employee = null;
        for (int i = 0; i < 10; i++) {
            employee = new Employee(null, "name" + i, "john" + i + "@gmail.com");
            employeeService.save(employee);
        }
    }

}
