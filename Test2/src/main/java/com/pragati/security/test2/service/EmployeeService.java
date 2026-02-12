package com.pragati.security.test2.service;

import com.pragati.security.test2.model.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @PersistenceContext(unitName = "appPU")
    private EntityManager em;

    @Transactional
    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    @Transactional
    public Employee update(Long id, Employee updated) {
        Employee emp = em.find(Employee.class, id);
        if (emp == null) return null;

        emp.setName(updated.getName());
        emp.setDepartment(updated.getDepartment());
        return emp;
    }

    @Transactional
    public boolean delete(Long id) {
        Employee emp = em.find(Employee.class, id);
        if (emp == null) return false;

        em.remove(emp);
        return true;
    }
}
