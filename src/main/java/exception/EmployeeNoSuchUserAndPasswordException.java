package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 这是个异常类，用于全局的异常捕获
 * 表示没有账号密码都对的
 */
@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT, reason = "No such department user or password!")

public class EmployeeNoSuchUserAndPasswordException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public EmployeeNoSuchUserAndPasswordException(String message){
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
