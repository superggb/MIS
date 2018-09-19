package dao;

import entity.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TransferDaoTest {

    @Autowired
    TransferDao transferDao;

    @Test
    public void testAddTransfer(){
        transferDao.addTransferRecord(100003,11001,11002);
    }

    @Test
    public void testUpdateTransfer(){
        transferDao.updateTransferRecord(4,100003,11002,11003);
    }

    @Test
    public void selectTransferOrderByTimeTest(){
        List<Transfer> transfers = transferDao.selectTransferOrderByTime(1,10);
        for (Transfer transfer :
                transfers) {
            System.out.println(transfer);
        }
    }

    @Test
    public void deleteTransferRecordById() throws Exception {
        int i=transferDao.deleteTransferRecordById(9);
        System.out.println(i);
    }
}
