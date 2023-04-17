package service;

import exceptions.EmployeeAlreadyAddException;
import exceptions.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;




@Service
public class  EmployeeServiceImpl implements  EmployeeService {
     private final Map<String, Employee>  employees;
     public EmployeeServiceImpl(){
         employees = new HashMap<>();

     }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public  Employee add(String firstName, String lastName, int department, double salary) {
        Employee empl = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(empl.getFirstName()+ empl.getLastName())){
            throw new EmployeeAlreadyAddException();
        }
       employees.put(empl.getFirstName() + empl.getLastName(), empl);
        return empl;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee empl = find(firstName,lastName);
        employees.remove(empl.getFirstName()+ empl.getLastName());
            return empl;
        }


    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }



    }




