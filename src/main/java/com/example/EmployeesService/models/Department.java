package com.example.EmployeesService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"department"})
    @OneToMany(mappedBy="department", fetch = FetchType.LAZY)
    private List<Employee> employeesList;

    public Department(){

    }

    public Department(String name){
        this.name = name;
        this.employeesList = new ArrayList<Employee>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }
}
