package com.snigdha.springboot.cruddemo.rest;

import com.snigdha.springboot.cruddemo.dao.EmployeeDAO;
import com.snigdha.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.snigdha.springboot.cruddemo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
class EmployeeRestController {

    /* We are calling the DAO layer directly, without the Service layer
    private EmployeeDAO employeeDAO;

    //quick and dirty : inject employee dao (use constructor injection)

    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    } */

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET/employees/{employeeId}
    // for getting employees
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST / employees - add new employee
    @PostMapping("/employees")
    //@RequestBody is to handle the request that will come in JSON
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //also just in case they pass an id JSON...set id to 0
        //this is to force a save of new item ... instead of update the id of existing item

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT/ employees - update existimg employee
    // this updates a particular id data
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    // add mapping for DELETE / employees/{employeeID} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - "+ employeeId;

    }



}