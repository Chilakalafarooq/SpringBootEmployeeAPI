package farooq.com.EmployeeDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farooq.com.EmployeeDetails.entity.EmployeeDetails;
@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}
