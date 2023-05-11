package com.snigdha.springboot.cruddemo.service;

import com.snigdha.springboot.cruddemo.dao.EmployeeRepository;
import com.snigdha.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    //constructor injection for EmployeeDAO
   // @Autowired

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll(){
       return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //"Optional" is a different pattern instead of having to check for nulls.
        //Checks if variable is holding a value or not

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find id - " + theId);
        }
        return theEmployee;
    }

   // @Transactional --> JpaRepository provides this functionality on its own
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

  //  @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}
