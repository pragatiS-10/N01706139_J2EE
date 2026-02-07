package com.example.employeerestapi.services;

import com.example.employeerestapi.models.Employee;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> getAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public Employee update(Long id, Employee employee) {
        Employee existing = em.find(Employee.class, id);
        if (existing != null) {
            existing.setFirstName(employee.getFirstName());
            existing.setLastName(employee.getLastName());
            existing.setEmail(employee.getEmail());
            em.merge(existing);
            return existing;
        }
        return null;
    }

    public boolean delete(Long id) {
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            em.remove(employee);
            return true;
        }
        return false;
    }
}
