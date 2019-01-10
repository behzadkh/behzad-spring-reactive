package com.behzad.spring.reactive.app.services;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.repositories.EmployeeReactiveRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeReactiveRepo employeeReactiveRepo;

    public Mono<Employee> findOneById(Long id) {
        return employeeReactiveRepo.findById(id);

    }

    public Flux<Employee> findAll() {
        return employeeReactiveRepo.findAll();
    }

    public Mono<Employee> save(Employee employee) {
        logger.info(employee + " is saved.");
        return employeeReactiveRepo.save(employee);
    }

    public Mono<Long> count() {
        return employeeReactiveRepo.count();
    }

    public Mono<Void> deleteById(Long id) {
        return employeeReactiveRepo.deleteById(id);
    }

    public Flux<Void> deleteAll() {
        return this.employeeReactiveRepo.findAll()
                .flatMap(e -> employeeReactiveRepo.deleteById(e.getId()));
    }

}
