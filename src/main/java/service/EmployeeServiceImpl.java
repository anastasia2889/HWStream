package service;

import exceptions.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;




@Service
public class  EmployeeServiceImpl implements  EmployeeService {
     private final Map<String, Employee>  employees;
    @Override
    //Данный блок кода служит для заполнения данных сотрудников с целью тестирования приложения
    public boolean fillEmployees() {
        employees.put("Sergey Zhdanov", new Employee("Sergey", "Zhdanov", 2));
        employees.put("Oleg Petrov", new Employee("Oleg", "Petrov", 1));
        employees.put("Konstantin Mihalkov", new Employee("Konstantin", "Mihalkov", 3));
        employees.get("Konstantin Mihalkov").setSalary(3000.0);
        employees.put("Petr Sergeev", new Employee("Petr", "Sergeev", 3));
        employees.get("Petr Sergeev").setSalary(67000.0);
        return true;
    }

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee empl = new Employee(firstName, lastName);
        if (employees.containsKey((empl.getFullName()))) {
            return employees.get((empl.getFullName()));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee add(String firstName, String lastName, int department) {
        Employee empl = new Employee(firstName, lastName);
        empl.setDepartment(department);
        if (department == 1) {
            empl.setSalary(15000.0);
        } else if (department == 2) {
            empl.setSalary(20000.0);
        }
        employees.put((empl.getFullName()), empl);
        return empl;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (employees.containsKey((new Employee(firstName, lastName).getFullName()))) {
            return employees.remove((new Employee(firstName, lastName).getFullName()));
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee findMinSalaryInDepartment(int department) {
        //в  цикле сравниваем записи сотрудником в нужном отделе
        List<Employee> findMin = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .sorted((employee1, employee2) -> (int) (employee1.getSalary()-employee2.getSalary())).toList();
        return findMin.get(0);

    }

    @Override
    public Employee findMaxSalaryInDepartment(int department) {
        List<Employee> findMax = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .sorted((employee1, employee2) -> (int) (employee2.getSalary()-employee1.getSalary())).toList();
        return findMax.get(0);
    }

    @Override
    public Collection<Employee> findAllInDepartment(int department) {
        Collection<Employee> employeesInDepartment = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department).toList();
        return employeesInDepartment;
    }

    @Override
    public Collection<Employee>findAllByDepartments() {
        Collection<Employee> employeesByDepartment = employees.values().stream()
                .sorted((employee1, employee2) -> employee1.getDepartment() - employee2.getDepartment()).toList();
        return employeesByDepartment;
    }
}



