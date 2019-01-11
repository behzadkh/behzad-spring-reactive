package com.behzad.spring.reactive.app.controllers;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@RestController
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Random random = new Random();


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/find/one/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.findOneById(id).defaultIfEmpty(new Employee(null, "null", "null"));
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/save")
    public Mono<Employee> save() {
        return count().flatMap(this::apply);
    }


    @GetMapping("/count")
    public Mono<Long> count() {
        return employeeService.count();
    }


    @GetMapping("/delete")
    public Flux<Void> deleteAll() {
        return employeeService.deleteAll();
    }

    private Mono<? extends Employee> apply(Long count) {
        logger.info("count = " + count);
        Mono<Employee> employeeMono = null;
        if (count < 10) {
            int r = random.nextInt(1000);
            employeeMono = Mono.just(new Employee(null, "name" + r, "name" + r + "@gmail.com"))
                    .flatMap(e -> this.employeeService.save(e));
        }
        return employeeMono;
    }
}
