package service;

import model.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentID);
    Employee getEmployeeWithMinSalary(Integer departmentID);
    List<Employee> getEmployeesByDepartment(Integer departmentID);
    Map<Integer, List<Employee>> getEmployeesCollectedByDepartment();
}
