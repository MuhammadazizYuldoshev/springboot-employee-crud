package uz.pdp.springbootemployeecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootemployeecrud.model.Employee;
import uz.pdp.springbootemployeecrud.service.EmployeeService;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private EmployeeService employeeService;

   @RequestMapping("/")
    public String homePage(Model model){
       List<Employee> allEmployees = employeeService.getAllEmployees();
       model.addAttribute("employeeList",allEmployees);
       return "home-page";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
       employeeService.save(employee);

       return "redirect:/";
    }


}
