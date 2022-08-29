package com.EmployeeCRUD.CRUD.Repository;

import com.EmployeeCRUD.CRUD.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
