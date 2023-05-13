package com.snigdha.springboot.cruddemo.dao;

import com.snigdha.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* @RepositoryRestResource(path="members")
now the URL will be http://localhost:8080/magic-api/members  */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Entity type - Employee, Primary key - Integer

    //that's it... no need to write any code LOL!
}
