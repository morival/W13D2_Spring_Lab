package com.example.EmployeesService;

import com.example.EmployeesService.models.Department;
import com.example.EmployeesService.models.Employee;
import com.example.EmployeesService.models.Project;
import com.example.EmployeesService.repositories.DepartmentRepository;
import com.example.EmployeesService.repositories.EmployeeRepository;
import com.example.EmployeesService.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

//@AutoConfigureTestDatabase
@SpringBootTest
class EmployeesServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createDepartmentEmployeeAndProject() {
		Department codeClan = new Department("CodeClan");
		departmentRepository.save(codeClan);

		Employee john = new Employee("John", "Harper", 1, codeClan);
		Employee roosa = new Employee("Roosa", "Päivänsalo", 2, codeClan);
		Employee juan = new Employee("Juan", "Ruiz", 3, codeClan);
		employeeRepository.save(john);
		employeeRepository.save(roosa);
		employeeRepository.save(juan);

		Project java = new Project("Java", 15);
		Project python = new Project("Python", 10);
		Project html = new Project("HTML", 10);
		projectRepository.save(java);
		projectRepository.save(python);
		projectRepository.save(html);

		codeClan.addEmployee(john);
		codeClan.addEmployee(roosa);
		codeClan.addEmployee(juan);
		departmentRepository.save(codeClan);

		john.addProject(java);
		employeeRepository.save(john);
		roosa.addProject(python);
		employeeRepository.save(roosa);
		juan.addProject(html);
		employeeRepository.save(juan);

		java.addEmployee(john);
		projectRepository.save(java);
//		java.addEmployee(juan);
//		python.addEmployee(john);
		python.addEmployee(roosa);
		projectRepository.save(python);
		html.addEmployee(juan);
		projectRepository.save(html);


	}
}
