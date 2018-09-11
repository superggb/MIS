package util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class TimeUtil {

    @Test
    public void testComputeEndTime(){
        System.out.println(new Timestamp(System.nanoTime()));
        Timestamp timestamp = ErwinSmithTime.computeEndTime(new Timestamp(System.nanoTime()), 3);
        System.out.println(timestamp);
    }
}
