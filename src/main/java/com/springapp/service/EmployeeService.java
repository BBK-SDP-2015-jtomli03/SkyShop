package com.springapp.service;

import com.springapp.dao.EmployeeDao;
import com.springapp.model.Employee;

import java.util.List;

public class EmployeeService {

	private static EmployeeDao employeeDao;

	public EmployeeService() {
		employeeDao = new EmployeeDao();
	}

	public void persist(Employee entity) {
		employeeDao.openCurrentSessionwithTransaction();
		employeeDao.persist(entity);
		employeeDao.closeCurrentSessionwithTransaction();
	}

	public void update(Employee entity) {
		employeeDao.openCurrentSessionwithTransaction();
		employeeDao.update(entity);
		employeeDao.closeCurrentSessionwithTransaction();
	}

	public Employee findById(String id) {
		employeeDao.openCurrentSession();
		Employee employee = employeeDao.findById(id);
		employeeDao.closeCurrentSession();
		return employee;
	}

	public void delete(String id) {
		employeeDao.openCurrentSessionwithTransaction();
		Employee employee = employeeDao.findById(id);
		employeeDao.delete(employee);
		employeeDao.closeCurrentSessionwithTransaction();
	}

	public List<Employee> findAll() {
		employeeDao.openCurrentSession();
		List<Employee> employees = employeeDao.findAll();
		employeeDao.closeCurrentSession();
		return employees;
	}

	public void deleteAll() {
		employeeDao.openCurrentSessionwithTransaction();
		employeeDao.deleteAll();
		employeeDao.closeCurrentSessionwithTransaction();
	}

	public EmployeeDao employeeDao() {
		return employeeDao;
	}
}
