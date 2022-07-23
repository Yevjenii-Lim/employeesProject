package com.yevhenii.spring.mvc_aop.dao;

import com.yevhenii.spring.mvc_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAllEmployees(){

        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();

        return employeeList;
    }

    @Override
    public void saveEmp(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emp);
    }

    @Override
    public Employee getEmp(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmp(Employee employee){
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
    }

    @Override
    public void deleteEmpWithId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("delete from Employee where id =:employeeId");
        employeeQuery.setParameter("employeeId", id);
        employeeQuery.executeUpdate();
    }
}
