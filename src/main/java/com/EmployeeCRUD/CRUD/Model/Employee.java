package com.EmployeeCRUD.CRUD.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private @Getter @Setter long id;

    @Column(name="first_name")
    private @Getter @Setter  String firstName;
    @Column(name="last_name")
    private @Getter @Setter String lastName;
    @Column(name="email")
    private @Getter @Setter String email;
}