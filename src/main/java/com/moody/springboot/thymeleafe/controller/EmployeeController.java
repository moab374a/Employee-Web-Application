package com.moody.springboot.thymeleafe.controller;


import java.util.List;
import java.util.Optional;


import com.moody.springboot.thymeleafe.entity.Employee;
import com.moody.springboot.thymeleafe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

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

        return "employees/listEmployees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        //Creat model attribute to bind from data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee" , theEmployee);
        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String shoFormForUpdate(@RequestParam("employeeId") int theId , Model theModel)
    {
        //get the employee from there service
        Employee theEmployee =  employeeService.findById(theId);

        //set employee as a model attribute to pre-populate the form

        theModel.addAttribute("employee" , theEmployee);

        //send over to our form

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
        // save the employee
        employeeService.save(theEmployee);

        //use a redirect to privent duplicate submission

        return "redirect:/employees/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
    {
        //delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";
    }


}









