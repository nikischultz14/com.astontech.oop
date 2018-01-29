package com.astontech.dao;

import com.astontech.bo.Employee;

import java.util.List;

public interface EmployeeDAO {
    //Get Methods
    public Employee getEmployeeById(int employeeId);
    public List<Employee> getEmployeeList();


    //Execute Methods
    public int insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(int employeeId);
}





