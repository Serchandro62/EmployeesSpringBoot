package com.serch.web_page_trial_1.web_page_trial_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serch.web_page_trial_1.web_page_trial_1.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long>{

}
