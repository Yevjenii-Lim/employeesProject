package com.yevhenii.spring.mvc_aop.service;

import com.yevhenii.spring.mvc_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void addNewEmp(Employee employee);

    public Employee getEmp(int id);

    public void deleteEmp(Employee employee);

    public void deleteEmpWithId(int id);
}
