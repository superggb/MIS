package controller;


import exception.DepartmentNoSuchUserAndPasswordException;
import exception.EmployeeNoSuchUserAndPasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DepartmentNoSuchUserAndPasswordException.class)
    public ModelAndView verifyDepartmentError(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ExceptionHandler(value = EmployeeNoSuchUserAndPasswordException.class)
    public ModelAndView verifyEmployeeError(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
