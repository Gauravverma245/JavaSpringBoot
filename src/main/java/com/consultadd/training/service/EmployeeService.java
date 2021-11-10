package com.consultadd.training.service;


import com.consultadd.training.model.Employee;
import com.consultadd.training.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // For Get Request
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    // For Post Request

    public String saveEmployees(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "Couldn't save data. Id already exists.";
        }else{
            employeeRepository.save(employee);
            return "Employee data saved successfully.";
        }
    }

    // For Put Request
    public String updateEmployee(Employee employee){
        if(!employeeRepository.existsById(employee.getId())){
            return "Couldn't update data. Id doesn't exists.";
        }else{
            employeeRepository.save(employee);
            return "Employee data saved successfully.";
        }
    }

    public String deleteEmployee(Employee employee){
        if(!employeeRepository.existsById(employee.getId())){
            return "Couldn't Delete Data. Id doesn't exists.";
        }else{
            employeeRepository.delete(employee);
            return "Employee data deleted successfully.";
        }
    }





}
