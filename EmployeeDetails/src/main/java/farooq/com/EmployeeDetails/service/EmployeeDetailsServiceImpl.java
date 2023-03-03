package farooq.com.EmployeeDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farooq.com.EmployeeDetails.entity.EmployeeDetails;
import farooq.com.EmployeeDetails.exception.EmployeeDetailsException;
import farooq.com.EmployeeDetails.exception.EmployeeDetailsNotFoundException;
import farooq.com.EmployeeDetails.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    private final EmployeeDetailsRepository repository;

    @Autowired
    public EmployeeDetailsServiceImpl(EmployeeDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not get employee details: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDetails getEmployeeById(Long id) {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new EmployeeDetailsNotFoundException("Employee with id " + id + " not found."));
        } catch (EmployeeDetailsNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not get employee details: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDetails addEmployee(EmployeeDetails employee) {
        try {
            return repository.save(employee);
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not create employee details: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDetails updateEmployee(Long id, EmployeeDetails employee) {
        try {
            EmployeeDetails existingEmployee = repository.findById(id)
                    .orElseThrow(() -> new EmployeeDetailsNotFoundException("Employee with id " + id + " not found."));
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            return repository.save(existingEmployee);
        } catch (EmployeeDetailsNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not update employee details: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new EmployeeDetailsException("Could not delete employee details: " + e.getMessage());
        }
    }
}