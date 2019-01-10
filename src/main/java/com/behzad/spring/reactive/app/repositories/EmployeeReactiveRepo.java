package com.behzad.spring.reactive.app.repositories;

import com.behzad.spring.reactive.app.entities.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeReactiveRepo extends ReactiveCrudRepository<Employee, Long> {

}
