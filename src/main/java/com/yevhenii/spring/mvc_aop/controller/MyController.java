package com.yevhenii.spring.mvc_aop.controller;

import com.yevhenii.spring.mvc_aop.dao.EmployeeDAO;
import com.yevhenii.spring.mvc_aop.entity.Employee;
import com.yevhenii.spring.mvc_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {


    @Autowired
//    @Lazy
    private EmployeeService employeeService;


    @RequestMapping("/")
    public String showEmps(Model model){

        System.out.println("hello world");
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("allEmps", employeeList);

        return "show-emps";
    }

    @RequestMapping("/add-new-emp")
    public String addNewEmpPage(Model model) {

        model.addAttribute("employee", new Employee());

        return "add-new-emp";
    }

    @RequestMapping("/save-emp")
    public String saveEmp(@ModelAttribute("employee") Employee employee) {

        employeeService.addNewEmp(employee);

        return "redirect:/";
    }

    @RequestMapping("updateInfo")
    public String updateInfoEmp(@RequestParam("empId") int id, Model model) {
        Employee emp = employeeService.getEmp(id);
        model.addAttribute("employee", emp);
        return "add-new-emp";
    }
    @RequestMapping("deleteEmp")
    public String deleteEmp(@RequestParam("empId") int id) {
        Employee emp = employeeService.getEmp(id);

        employeeService.deleteEmp(emp);
        return "redirect:/";
    }

    @RequestMapping("deleteEmpWithId")
    public String deleteEmpWithId(@RequestParam("empId") int id) {
        employeeService.deleteEmpWithId(id);
        return "redirect:/";
    }


}
