package com.springapp.dao;
import com.springapp.model.Employee;

import java.util.List;

public interface EmployeesDao {
	public abstract Employee hireEmployee(Employee employee);
	public abstract void updateEmployee(Employee employee);
	public abstract void changeEmployeeDepartment(Employee employee);
	public abstract void fireEmployee(Employee employee);
	public abstract List getAllEmployees();
	public abstract List getEmployeesByDepartment(String departmentName);
}
