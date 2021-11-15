package com.consultadd.training.controller;


import com.consultadd.training.model.Employee;
import com.consultadd.training.model.JwtResponse;
import com.consultadd.training.repository.EmployeeRepository;
import com.consultadd.training.service.EmployeeService;
import com.consultadd.training.utlity.JWTUtility;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.spec.ECParameterSpec;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Employee employee;

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

    @DeleteMapping("/deleteemp")
    public String deleteData(@RequestBody Employee employee){
        return employeeService.deleteEmployee(employee);
    }


    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody Employee employee) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            employee.getUsername(),
                            employee.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new Exception("Invalid_Credentials", e);
        }

        final UserDetails userDetails = employeeService.loadUserByUsername(employee.getUsername());

        final String token = jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }

}
