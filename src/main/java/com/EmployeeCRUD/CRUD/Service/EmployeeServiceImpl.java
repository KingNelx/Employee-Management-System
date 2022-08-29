package com.EmployeeCRUD.CRUD.Service;

import com.EmployeeCRUD.CRUD.Model.Employee;
import com.EmployeeCRUD.CRUD.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;

        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException(" Employee not found: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        this.employeeRepository.deleteById(id);
    }
}
