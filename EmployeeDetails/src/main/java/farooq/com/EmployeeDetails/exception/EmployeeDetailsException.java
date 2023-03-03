package farooq.com.EmployeeDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeDetailsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDetailsException(String message) {
        super(message);
    }
}
