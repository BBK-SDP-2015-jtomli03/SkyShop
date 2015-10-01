package com.springapp.dao;

import com.springapp.model.Department;

import java.util.List;

public interface DepartmentsDao {
	public abstract Department createDepartment(Department department);
	public abstract Department updateDepartment(Department department);
	public abstract Department getDepartmentById(int departmentId);
	public abstract List getAllDepartments();
}
