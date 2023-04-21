package com.snigdha.cruddemo.entity;

import jakarta.persistence.*;

//Student class is the entity class
@Entity
@Table(name="student")  // Name of the database table
public class Student {

    //define field

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //For declaring the field as Primary Key
    @Column(name="id")  //DB column name
    private int id;

    @Column(name="first_name") //DB column name
    private String firstName;

    @Column(name="last_name")  //DB column name
    private String lastName;

    @Column(name="email")  //DB column name
    private String email;

    //define constructors
    public Student(){

    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() method

    @Override
    public String  toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", email=" + email +
                '}';
    }
}
