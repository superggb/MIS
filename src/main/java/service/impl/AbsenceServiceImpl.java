package service.impl;

import dao.AbsenceDao;
import entity.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AbsenceService;

import java.sql.Timestamp;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    AbsenceDao absenceDao;

    /**
     * 这个方法用于返回刚插入的那条记录，已经包含了主键值
     * @param eid
     * @param starttime
     * @param endtime
     * @param state
     * @param description
     * @return
     */
    @Override
    public Absence addAbsenceRecord(int eid, Timestamp starttime, Timestamp endtime, int state, String description) {
        Absence absence = new Absence();
        absence.setEid(eid);
        absence.setStarttime(starttime);
        absence.setEndtime(endtime);
        absence.setState(state);
        absence.setDescription(description);
        absenceDao.addAbsenceRecord(absence);
        return absence;
    }
}
