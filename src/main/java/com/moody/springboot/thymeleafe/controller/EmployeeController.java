package com.moody.springboot.thymeleafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.moody.springboot.thymeleafe.entity.Employee;
import com.moody.springboot.thymeleafe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/employees")
public class EmployeeController {



    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        //get the Employee from the DataBase
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "listEmployees";
    }
}









