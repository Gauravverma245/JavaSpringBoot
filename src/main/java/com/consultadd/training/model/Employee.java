package com.consultadd.training.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private int age;
    private String username;
    private String password;
    private String role;

    public Employee(){

    }

    public Employee(String id, String name, int age, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
