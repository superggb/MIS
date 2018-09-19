package service.impl;

import dto.TransferInfo;
import entity.Department;
import entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AccountRelatedImplTest {


    @Autowired
    private AccountRelatedImpl accountRelated;


    @Test
    public void loginTest(){
        Employee employee = accountRelated.loginEmployee(100001, "123456");


        Department department = accountRelated.loginDepartment(11001,"123456");
        if (null == department){
            System.out.println("Test: no such department.");
        } else {
            System.out.println("Test: department name is: " + department.getName());
        }
    }

    @Test
    public void registerTest(){
        accountRelated.register("大厦", "123456",(float) 1.1,11003);
    }


    @Test
    public void updateEmployeeTest(){
        accountRelated.updateEmployeePassword(100002,"宋系三", "123456","123");
    }

    @Test
    public void updateEmployeeInfoTest(){
        accountRelated.updateEmployeeInfo(100002,1,11001,11003);
    }

    @Test
    public void deleteEmployeeTest(){
        accountRelated.deleteEmployee(100002);
    }

    @Test
    public void updateTransferTest(){
        accountRelated.updateTransfer(4,100003,11004,11005);
    }

    @Test
    public void registerDepartment() {
        accountRelated.register("体育学院", "123456");
    }

    @Test
    public void deleteDepartment() {
        accountRelated.deleteDepartment(11013);
    }

    @Test
    public void updateDepartment() {
        accountRelated.updateDepartment(11001, "信息工程学院", "zhangjie");
    }

    @Test
    public void findTransferTest(){
        List<TransferInfo> transferInfos = accountRelated.findTransferInfoOrderByDate(0,10);
        for (TransferInfo transferInfo:
             transferInfos) {
            System.out.println(transferInfo);
        }
    }

    @Test
    public void findDepartment(){
        List<Department> departments = accountRelated.findDepartment(0,20);
        for (Department department :
                departments) {
            System.out.println(department);
        }
    }

    @Test
    public void findDepartmentByDid(){
        Department department = accountRelated.findDepartmentByDid(11001);
        System.out.println(department);
    }

    @Test
    public void findEmployeeByEidService(){
        Employee employee = accountRelated.findEmployeeByEid(100003);
        System.out.println(employee);
    }

    @Test
    public void addTransferRecordTest(){
        accountRelated.addTransferRecord(100003,-1,2);
    }

}
