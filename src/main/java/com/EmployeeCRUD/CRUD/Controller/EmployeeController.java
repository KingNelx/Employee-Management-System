package com.EmployeeCRUD.CRUD.Controller;

import com.EmployeeCRUD.CRUD.Model.Employee;
import com.EmployeeCRUD.CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        model.addAttribute("HeadingTitle", "Employee Lists");
        return "index";
    }

    // method handler
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create a model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(){
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable (value = "id") long id, Model model){
    // Get employee from the service
        Employee employee = employeeService.getEmployeeByID(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
        public String deleteEmployee(@PathVariable (value = "id") long id){
                // delete method from service (create a  delete method in interface)
        this.employeeService.deleteEmployee(id);
        return "redirect:/";
        }

    @GetMapping("/login")
    public String homeLogin(){
        return "log_in";
    }

    @GetMapping("/createAccount")
    public String createAccount(){
        return "create_Account";
    }

}