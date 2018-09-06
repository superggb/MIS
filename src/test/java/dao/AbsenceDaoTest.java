package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AbsenceDaoTest {

    @Autowired
    AbsenceDao absenceDao;

    @Test
    public void addRecord(){
        //absenceDao.addAbsenceRecord(100001, new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),1,"sa");
    }

}
