package com.consultadd.training.controller;


import com.consultadd.training.model.Employee;
import com.consultadd.training.repository.EmployeeRepository;
import com.consultadd.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.spec.ECParameterSpec;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
       return employeeService.getEmployees();
    }

    @PostMapping("/addemp")
    public String saveEmployees(@RequestBody Employee employee){
        return employeeService.saveEmployees(employee);
    }

    @PutMapping("/updateemp")
    public String updateData(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteemp")
    public String deleteData(@RequestBody Employee employee){
        return employeeService.deleteEmployee(employee);
    }

}
