package com.behzad.spring.reactive.app;

import com.behzad.spring.reactive.app.entities.Employee;
import com.behzad.spring.reactive.app.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BehzadSpringReactiveApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Autowired
    private EmployeeService employeeReactiveRepo;

    @Test
    public void delete() {
        Flux<Void> deleteAll = this.employeeReactiveRepo.findAll()
                .flatMap(e -> employeeReactiveRepo.deleteById(e.getId()));
//        flatMap(r -> employeeReactiveRepo.deleteById(r.getId()));
        StepVerifier
                .create(deleteAll)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    public void save() {

//        Flux<Employee> employeeFlux = Flux.just(new Employee(null, "name1", "name1@gmail.com"),new Employee(null, "name2", "name2@gmail.com") )
//                .flatMap(e -> this.employeeReactiveRepo.save(e));

        Mono<Employee> employeeFlux = Mono.just(new Employee(null, "name1", "name1@gmail.com"))
                .flatMap(e -> this.employeeReactiveRepo.save(e));
        StepVerifier
                .create(employeeFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void all() {
        Flux<Employee> all = this.employeeReactiveRepo.findAll();
        StepVerifier
                .create(all)
                .expectNextCount(3)
                .verifyComplete();
    }

}

