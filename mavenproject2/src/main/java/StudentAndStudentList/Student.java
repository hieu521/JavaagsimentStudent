/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentAndStudentList;

import java.io.Serializable;

/**
 *
 * @author tltkh
 */
public class Student implements Serializable {
     private String ID, name, email;
    private float  tuition;
    private int age;

    public Student() {
    }

    public Student(String ID, String name, String email, float  tuition, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this. tuition =  tuition;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String employeeID) {
        this.ID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTuition() {
        return  tuition;
    }

    public void setTuition(float salary) {
        this. tuition = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
