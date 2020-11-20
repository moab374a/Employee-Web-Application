package com.moody.springboot.thymeleafe.DAO;

import com.moody.springboot.thymeleafe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();
}
