package com.springapp.dao;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.springapp.model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentsDaoImp implements DepartmentsDao {


	public Department getDepartmentById(int departmentId) {
		Connection connection = null;
		Department department;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Departments WHERE id = " + departmentId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				department = new Department(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("employeeCount"));
			}
			else{
				department = null;
			}
		} catch (Exception e){
			department = null;
		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}

		return department;
	}


	public ArrayList<Department> getAllDepartments(){
		Connection connection = null;
		ArrayList<Department> departments = new ArrayList<Department>();

		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Products";
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){
				Department department = new Department(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("employeeCount"));
				departments.add(department);
			}
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO departments (name, employeeCount) "
					+ "VALUES ('" + department.getDepartmentName() + "', "
					+ "employeeCount= " + department.getNumberOfEmployees() + ")";
			stmt.executeQuery(query);
		} catch (Exception e){
		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}

		return department;
	}

	public void deleteDepartment(Department department) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM departments WHERE id =" + department.getDepartmentID();
			stmt.executeQuery(query);
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}
	}

	public Department updateDepartment(Department department) {
		Connection connection = null;
		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE departments SET "
					+ "name = '" + department.getDepartmentName() + "', "
					+ "employeeCount= " + department.getNumberOfEmployees()
					+ "WHERE id = " + department.getDepartmentID();
			stmt.executeQuery(query);
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}
		return department;
	}
}
