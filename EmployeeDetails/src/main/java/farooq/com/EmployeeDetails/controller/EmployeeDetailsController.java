package farooq.com.EmployeeDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import farooq.com.EmployeeDetails.entity.EmployeeDetails;
import farooq.com.EmployeeDetails.exception.EmployeeDetailsException;
import farooq.com.EmployeeDetails.exception.EmployeeDetailsNotFoundException;
import farooq.com.EmployeeDetails.repository.EmployeeDetailsRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeDetailsController {
    private final EmployeeDetailsRepository repository;

    @Autowired
    public EmployeeDetailsController(EmployeeDetailsRepository repository) {
        this.repository = repository;
    }

    //http://localhost:8080/employees
    @PostMapping
    public ResponseEntity<EmployeeDetails> addEmployee(@RequestBody EmployeeDetails employee) {
        try {
            EmployeeDetails savedEmployee = repository.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not create employee details: " + e.getMessage());
        }
    }
    //http://localhost:8080/employees/1
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable Long id) {
        try {
            EmployeeDetails employee = repository.findById(id)
                    .orElseThrow(() -> new EmployeeDetailsNotFoundException("Employee with id " + id + " not found."));
            return ResponseEntity.ok(employee);
        } catch (EmployeeDetailsNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not get employee details: " + e.getMessage());
        }
    }
    //http://localhost:8080/employees/1
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails employee) {
        try {
            EmployeeDetails existingEmployee = repository.findById(id)
                    .orElseThrow(() -> new EmployeeDetailsNotFoundException("Employee with id " + id + " not found."));
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            EmployeeDetails updatedEmployee = repository.save(existingEmployee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeDetailsNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not update employee details: " + e.getMessage());
        }
    }
    //http://localhost:8080/employees/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not delete employee details: " + e.getMessage());
        }
    }
    //http://localhost:8080/employees
    @GetMapping
    public ResponseEntity<List<EmployeeDetails>> getAllEmployees() {
        try {
            List<EmployeeDetails> employees = repository.findAll();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not get employee details: " + e.getMessage());
        }
    }

    
        
    
}
