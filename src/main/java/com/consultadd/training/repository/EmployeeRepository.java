package com.consultadd.training.repository;


import com.consultadd.training.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByUsername(String username);
}
