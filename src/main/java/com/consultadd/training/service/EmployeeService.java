package com.consultadd.training.service;


import com.consultadd.training.CustomUserDetails;
import com.consultadd.training.model.Employee;
import com.consultadd.training.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = employeeRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return new CustomUserDetails(user);

    }
}
