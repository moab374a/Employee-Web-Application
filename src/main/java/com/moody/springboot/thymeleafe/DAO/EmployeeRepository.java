package com.moody.springboot.thymeleafe.DAO;

import com.moody.springboot.thymeleafe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
