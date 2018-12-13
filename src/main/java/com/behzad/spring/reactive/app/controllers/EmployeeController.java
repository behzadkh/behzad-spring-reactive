package com.behzad.spring.reactive.app.controllers;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/find/one")
    private Mono<Employee> getEmployeeById() {
        return employeeService.findOne();
    }

    @GetMapping("/all")
    private Flux<Employee> getAllEmployees() {
        return employeeService.list();
    }

}
