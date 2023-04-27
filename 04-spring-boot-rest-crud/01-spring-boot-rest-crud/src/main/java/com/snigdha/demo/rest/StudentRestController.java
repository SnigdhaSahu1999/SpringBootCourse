package com.snigdha.demo.rest;

import com.snigdha.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once after the initialization of the bean

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    //define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    //@PathVariable is used bcoz we are passing student id at the URL
    public Student getStudent(@PathVariable int studentId){

        //just index into the list...keep it simple for now

        //check the studentId against list size

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }

    /*  @ExceptionHandler is used for only specific RestController, so we will use global exception handler
    // add an exception handler using @ExceptHandler, this will be executed if any exception is there
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return a ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler ... to catch any type of exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        //This line gives the full exception msg
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return a ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }*/



}
