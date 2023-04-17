package controller;

import model.Employee;
import org.springframework.web.bind.annotation. GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service. EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employee/add")
    public Employee addEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department,@RequestParam Double salary){
        return employeeService.add(firstName,lastName,department,salary);
}
    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
}

    }










