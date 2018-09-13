package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT, reason = "No such employee user or password!")
public class DepartmentNoSuchUserAndPasswordException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public DepartmentNoSuchUserAndPasswordException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
