package com.behzad.spring.reactive.app.services;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Flux<Employee> list() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Employee((i + 1L), ("e" + i), ("e" + i + "@gmial.com")));
        }
        return Flux.fromIterable(list);
    }

    public Mono<Employee> findOneByDB(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(Mono::just).orElse(null);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    public Mono<Employee> findOne() {
        return Mono.just(new Employee(1L, "e1", "e1@gmial.com"));
    }
}
