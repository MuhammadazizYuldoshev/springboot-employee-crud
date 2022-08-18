package uz.pdp.springbootemployeecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable(name = "id") int id,Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employeeList",employee);

        return "edit-page";

    }


}
