package model;

import java.util.Objects;

public class Employee {
    final private String firstName;
    final private String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        if (department == 1) {
            this.salary = 12000.0;
        } else if (department == 2) {
            this.salary = 35000.0;
        }
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
        if (department == 1) {
            this.salary = 12000.0;
        } else if (department == 2) {
            this.salary = 35000.0;
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " +  lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}