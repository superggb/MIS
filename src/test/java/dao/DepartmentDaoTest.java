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
        List<Department> departments=departmentDao.selectAll();
        for (Department department:departments
             ) {
            System.out.println(department);
        }

    }

}