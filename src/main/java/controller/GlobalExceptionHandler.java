package controller;


import exception.DataSourceMybatisException;
import exception.DepartmentNoSuchUserAndPasswordException;
import exception.EmployeeNoSuchUserAndPasswordException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DepartmentNoSuchUserAndPasswordException.class)
    public ModelAndView verifyDepartmentExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ExceptionHandler(value = EmployeeNoSuchUserAndPasswordException.class)
    public ModelAndView verifyEmployeeExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //TODO 往后可以只捕获这个数据库方面的异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView dataSourceExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("/error/dataException");
        return modelAndView;
    }

}
