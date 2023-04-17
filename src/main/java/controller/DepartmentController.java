package controller;

import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentID){
        return departmentService.getEmployeeWithMaxSalary(departmentID);
}
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentID){
        return departmentService.getEmployeeWithMinSalary(departmentID);
}
    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam Integer departmentID){
        return departmentService.getEmployeesByDepartment(departmentID);
    }
    @GetMapping("/all/collected-by-department")
    public Map<Integer, List<Employee>> getEmployeesCollectedByDepartment(){
        return departmentService.getEmployeesCollectedByDepartment();
    }
}