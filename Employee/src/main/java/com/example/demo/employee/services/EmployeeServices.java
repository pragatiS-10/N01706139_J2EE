package com.example.demo.employee.services;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.employee.model.Employee;
import jakarta.enterprise.context.ApplicationScoped;  // ADD THIS
@ApplicationScoped
public class EmployeeServices {
    private final List<Employee> employees = new ArrayList<>();
    public List<Employee> getAllEmployees(){
        return employees;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void deleteEmployee(Employee employee){
        employees.remove(employee);
    }
    public Employee getEmployeeById(int id){
        return employees.get(id);
    }
    public void updateEmployee(Employee employee, int id){
        employees.set(id, employee);
    }
    public int getEmployeeCount(){
        return employees.size();
    }
    public Employee getEmployeeByEmail(String email){
        for(Employee employee : employees){
            if(employee.getEmail().equals(email)) return employee;
        }
        return null;
    }
    public Employee getEmployeeByName(String name){
        for(Employee employee : employees){
            if(employee.getFirstName().equals(name)) return employee;
        }
        return null;
    }
}
