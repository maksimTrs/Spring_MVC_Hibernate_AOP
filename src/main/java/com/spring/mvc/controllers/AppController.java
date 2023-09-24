package com.spring.mvc.controllers;

import com.spring.mvc.dao.EmployeeDAO;
import com.spring.mvc.dao.EmployeeDAOImpl;
import com.spring.mvc.entities.Employee;
import com.spring.mvc.services.EmployeeService;
import com.spring.mvc.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/employees")
public class AppController {

    @Autowired
    private EmployeeService employeeService;


    // http://localhost:8084/Spring_MVC_Hibernate_AOP/employees/  --> 8084 = Tomcat port
    @RequestMapping("/")
    public String showAllEmployeesView(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);

        return "all-employees"; // This corresponds to the "all-employees.jsp" view
    }


    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("newEmployee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute(name = "newEmployee") Employee employee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employee-info";
        }

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }


    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int employeeId, Model model) {

        Employee employee = employeeService.getEmployee(employeeId);
        model.addAttribute("newEmployee", employee);

        return "employee-info";
    }


    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int employeeId) {
        employeeService.deleteEmployee(employeeId);

        return "redirect:/";
    }
}
