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
    public void addEmployee() {
        Employee employee = new Employee("张杰", (float) 1.1,"123456");
        employeeDao.addEmployee(employee, 11001);

        if (null == employee){
            System.out.println("Test: no such employee!");
        } else{
            System.out.println("Test: employee's eid is " + employee.getEid());
        }
    }

    @Test
    public void updateEmployeePassword(){
        employeeDao.updateEmployeePassword(100002,"宋系三", "123456","123");
    }

    @Test
    public void deleteEmployeeTest(){
        employeeDao.deleteEmployee(100001);
    }

    @Test
    public void findEmployeeByEidTest(){
        Employee employee = employeeDao.findEmployeeByEid(11003);
        System.out.println(employee);
    }
}
