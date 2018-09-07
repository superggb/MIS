package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SalaryDaoTest {
    @Autowired
    SalaryDao salaryDao;

    @Test
    public void testAddAndUpdateSalaryRecord(){
        //salaryDao.addSalaryRecord(100001, (float) 1000.0,"sa");
        salaryDao.updateSalary(100001,2000.0f,12.3f,"sad");
    }
}
