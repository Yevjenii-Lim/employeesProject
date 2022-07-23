package com.yevhenii.spring.mvc_aop.service;

import com.yevhenii.spring.mvc_aop.dao.EmployeeDAO;
import com.yevhenii.spring.mvc_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void addNewEmp(Employee employee) {
        employeeDAO.saveEmp(employee);
    }

    @Override
    @Transactional
    public Employee getEmp(int id) {
       return employeeDAO.getEmp(id);
    }

    @Override
    @Transactional
    public void deleteEmp(Employee employee) {
        employeeDAO.deleteEmp(employee);
    }

    @Override
    @Transactional
    public void deleteEmpWithId(int id) {
        employeeDAO.deleteEmpWithId(id);
    }
}
