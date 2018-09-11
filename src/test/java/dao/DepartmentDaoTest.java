package dao;

import entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DepartmentDaoTest {

    @Resource
    private DepartmentDao departmentDao;

    @Test
    public void selectAll() throws Exception {
        List<Department> departments=departmentDao.selectAll(0, 10);
        for (Department department:departments
             ) {
            System.out.println(department);
        }

    }

    @Test
    public void Login(){
    }

    @Test
    public void registerDepartment(){
        Department department = new Department();
        department.setName("体育学院");
        department.setPassword("123");
        departmentDao.registerDepartment(department);
        System.out.println(department.getDid());
    }

    @Test
    public void deleteDepartmentTest(){
        departmentDao.deleteDepartment(11015);
    }

    @Test
    public void updateDepartmentTest(){
        departmentDao.updateDepartment(new Department(11001,"外语学院", "123"));
    }

}