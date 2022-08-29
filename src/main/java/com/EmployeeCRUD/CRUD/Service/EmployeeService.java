package com.EmployeeCRUD.CRUD.Service;

import com.EmployeeCRUD.CRUD.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeByID(long id);
    void deleteEmployee(long id);
}
