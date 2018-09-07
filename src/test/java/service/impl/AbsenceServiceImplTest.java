package service.impl;

import entity.Absence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AbsenceServiceImplTest {

    @Autowired
    AbsenceServiceImpl absenceService;

    @Test
    public void testAddAbsenceRecord(){
        Absence absence = absenceService.addAbsenceRecord(100001, new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),1,"sa");
        System.out.println("TestAddAbsenceRecord: " + absence.getAid());
    }

    @Test
    public void testSelect() {
        List<Absence> absences = absenceService.selectAbsenceRecords(0,10);
        for (Absence absence :
                absences) {
            System.out.println(absence);
        }


        absences = absenceService.selectAbsenceRecords(11001,0,10);
        for (Absence absence :
                absences) {
            System.out.println(absence);
        }
    }
}
