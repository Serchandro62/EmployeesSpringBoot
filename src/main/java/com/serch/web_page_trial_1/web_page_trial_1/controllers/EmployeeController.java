package com.serch.web_page_trial_1.web_page_trial_1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serch.web_page_trial_1.web_page_trial_1.models.Employee;
import com.serch.web_page_trial_1.web_page_trial_1.services.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")

public class EmployeeController {

    @Autowired
    private IEmployeeService empServ;

    @GetMapping("/get")
    public List<Employee> getEmployees() {

        return empServ.getEmployees();

    }

    @PostMapping("/post")
    public void saveEmployee(@RequestBody Employee emp) {

        String realPhone = emp.getPhone().substring(0, 3) + " " + emp.getPhone().substring(3, 6) + " "
                + emp.getPhone().substring(6);
        emp.setPhone(realPhone);
        empServ.saveEmployee(emp);

    }

    @PutMapping("/put")
    public void editEmployee(@RequestBody Employee emp) {

        empServ.editEmployee(emp);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployees(@PathVariable Long id) {

        empServ.deleteEmployee(id);

    }

    @GetMapping("/pagination")
    public Page<Employee> getEmployeesPaged( @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return empServ.getEmployeesPaged(pageable);
    }

}
