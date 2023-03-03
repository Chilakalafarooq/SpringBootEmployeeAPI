package farooq.com.EmployeeDetails.service;

import java.util.List;

import farooq.com.EmployeeDetails.entity.EmployeeDetails;

public interface EmployeeDetailsService {
    List<EmployeeDetails> getAllEmployees();

    EmployeeDetails getEmployeeById(Long id);

    EmployeeDetails addEmployee(EmployeeDetails employee);

    EmployeeDetails updateEmployee(Long id, EmployeeDetails employee);

    void deleteEmployee(Long id);
}