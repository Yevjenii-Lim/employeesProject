package com.yevhenii.spring.mvc_aop.dao;

import com.yevhenii.spring.mvc_aop.entity.Employee;

import java.util.List;


public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmp(Employee emp);

    public Employee getEmp(int id);

    public void deleteEmp(Employee employee);

    public void deleteEmpWithId(int id);
}
