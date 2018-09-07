package service.impl;

import entity.Department;
import entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AccountRelatedImplTest {

    @Autowired
    private AccountRelatedImpl accountRelated;


    @Test
    public void loginTest(){
        Employee employee = accountRelated.loginEmployee(100001, "123456");
        if (null == employee){
            System.out.println("Test: no such employee.");
        } else {
            System.out.println("Test: employee name is: " + employee.getName());
        }

        Department department = accountRelated.loginDepartment(11001,"123456");
        if (null == department){
            System.out.println("Test: no such department.");
        } else {
            System.out.println("Test: department name is: " + department.getName());
        }
    }

    @Test
    public void registerTest(){
        Employee employee = new Employee("大厦", (float) 1.1,"123456");
        accountRelated.register("大厦", "123456",(float) 1.1,11001);
    }
}
