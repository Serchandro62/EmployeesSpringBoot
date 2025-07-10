package com.serch.web_page_trial_1.web_page_trial_1.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serch.web_page_trial_1.web_page_trial_1.models.Employee;

public interface IEmployeeService {

    public List<Employee> getEmployees();
    public Employee findEmployee(Long id);
    public void saveEmployee(Employee emp);
    public void deleteEmployee(Long id);
    public void editEmployee(Employee emp);
    public Page<Employee> getEmployeesPaged(Pageable pageable);

}
