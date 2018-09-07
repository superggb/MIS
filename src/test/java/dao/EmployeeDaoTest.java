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
        Employee employee = new Employee("张杰", (float) 1.1,"123456");
        employeeDao.addEmployee(employee, 11001);

        if (null == employee){
            System.out.println("Test: no such employee!");
        } else{
            System.out.println("Test: employee's eid is " + employee.getEid());
        }
    }
}
