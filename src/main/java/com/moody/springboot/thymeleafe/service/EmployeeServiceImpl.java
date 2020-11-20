package com.moody.springboot.thymeleafe.service;

import com.moody.springboot.thymeleafe.DAO.EmployeeRepository;
import com.moody.springboot.thymeleafe.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeService) {
        this.employeeRepository = theEmployeeService;
    }


    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
         Optional<Employee> result = employeeRepository.findById(theId);

         Employee theEmployee = null;
         if (result.isPresent())
         {
             theEmployee = result.get();
         } else // we didn't find the employee
         throw new RuntimeException("Employee id were not found" + theId);

         return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }



}
