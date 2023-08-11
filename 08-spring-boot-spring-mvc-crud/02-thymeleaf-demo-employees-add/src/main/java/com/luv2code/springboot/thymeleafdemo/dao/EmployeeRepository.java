package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!



    // add a method to sort employee list by last name
    public List<Employee> findAllByOrderByLastNameAsc();

    /*Spring Data JPA will parse the method name , looks for a specific format & pattern , creates appropriate query
    behind the scenes i.e "from Employee order by lastName asc"*/
}
