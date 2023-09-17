package com.snigdha.springboot.cruddemo.dao;

import com.snigdha.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* @RepositoryRestResource(path="members")*/

/*for this app the URL will be http://localhost:8090/magic-api/employees  */

//<Employee, Integer> : Employee is the entity name and primary key of Employee is having datatype int
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Entity type - Employee, Primary key - Integer

    //that's it... no need to write any code LOL!
}
