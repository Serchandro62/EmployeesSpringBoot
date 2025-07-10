package com.serch.web_page_trial_1.web_page_trial_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.serch.web_page_trial_1.web_page_trial_1.models.Employee;
import com.serch.web_page_trial_1.web_page_trial_1.repositories.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private IEmployeeRepository empRepo;

    @Override
    public List<Employee> getEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee findEmployee(Long id) {
        return empRepo.findById(id).orElse(null);
    }

    @Override
    public void saveEmployee(Employee emp) {
        empRepo.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }

    @Override
    public void editEmployee(Employee emp) {
        this.saveEmployee(emp);
    }

    @Override
    public Page<Employee> getEmployeesPaged(Pageable pageable) {
        return empRepo.findAll(pageable); //findAll() ya está hecho para aceptar pageable's 
    }
}
