package com.example.EmployeesService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_number")
    private int employeeNumber;


    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonIgnoreProperties({"employees"})
    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = { @JoinColumn(
                    name = "employee_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Project> projectsList;


    public Employee(){

    }

    public Employee(String firstName, String lastName, int employeeNumber, Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.projectsList = new ArrayList<Project>();
    }

    public Long getId() {
        return id;
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void addProject(Project project){
        projectsList.add(project);
    }

    public Department getDepartment() {
        return department;
    }
}
