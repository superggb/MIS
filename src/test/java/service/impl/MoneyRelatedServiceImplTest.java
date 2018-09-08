package service.impl;

import model.SalaryShow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class MoneyRelatedServiceImplTest {

    @Autowired
    MoneyRelatedServiceImpl moneyRelatedService;

    @Test
    public void test(){
        List<SalaryShow> salaryShows = moneyRelatedService.findSalaryOrderByDate(0,2);
        for (SalaryShow salaryShow:
              salaryShows) {
            System.out.println(salaryShow);
        }
    }
}
