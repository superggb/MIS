package dao;

import entity.Absence;
import entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AbsenceDaoTest {

    @Autowired
    AbsenceDao absenceDao;

    @Test
    public void selectRecords(){
        List<Absence> absences = absenceDao.selectAbsenceRecordsOrderByStartTime( 1,10);
        for (Absence absence :
                absences) {
            System.out.println(absence);
        }
    }

}
