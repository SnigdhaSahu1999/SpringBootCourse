package com.snigdha.cruddemo.dao;

import com.snigdha.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //to save a student in DB
    void save(Student theStudent);

    //to find a student
    Student findById(Integer id);

    //to find all students
    List<Student> findAll();

    //find a student by its last name
    List<Student> findByLastName(String theLastName);

    //to update a student
    void update(Student theStudent);

    //to delete a student
    void delete(Integer id);

    //to delete all the students of the DB
    int deleteAll();


}
