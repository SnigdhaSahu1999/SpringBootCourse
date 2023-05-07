package com.snigdha.springboot.cruddemo.dao;

import com.snigdha.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Entity type - Employee, Primary key - Integer

    //that's it... no need to write any code LOL!
}
