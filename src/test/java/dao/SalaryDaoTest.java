package dao;

import model.SalaryShow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void findSalaryByEidOrderByDateTest() {
        List<SalaryShow> salaryShows = salaryDao.findSalaryOrderByDate(0,2);
        for (SalaryShow salaryShow :
                salaryShows) {
            System.out.println(salaryShow);
        }
    }
}
