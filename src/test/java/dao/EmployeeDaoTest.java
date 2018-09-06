package dao;

import entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * It's for test!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class EmployeeDaoTest {
    @Resource
    EmployeeDao employeeDao;

    @Test
    public void Employee() {
        Employee employee = employeeDao.loginIn(100001,"123456");
        if (null == employee){
            System.out.println("Test: no such employee!");
        } else{
            System.out.println("Test: employee's name is " + employee.getName());
        }
    }
}
