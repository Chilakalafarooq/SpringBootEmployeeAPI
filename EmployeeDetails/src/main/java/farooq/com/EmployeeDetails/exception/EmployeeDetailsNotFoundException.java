package farooq.com.EmployeeDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeDetailsNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public EmployeeDetailsNotFoundException(String message) {
        super(message);
    }
}


