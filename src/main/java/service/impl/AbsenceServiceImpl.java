package service.impl;

import dao.AbsenceDao;
import entity.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AbsenceService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    AbsenceDao absenceDao;

    /**
     * 这个方法插入记录，已经包含了主键值
     * @param eid
     * @param starttime
     * @param endtime
     * @param state
     * @param description
     * @return 如果插入成功则返回已插入记录的对象化数据（包括主键）
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

    @Override
    public List<Absence> selectAbsenceRecords(int did, int start, int len) {
        return absenceDao.selectAbsenceRecordsByDidOrderByStartTime(did, start, len);
    }


    @Override
    public List<Absence> selectAbsenceRecords(int start, int len) {
        return absenceDao.selectAbsenceRecordsOrderByStartTime(start, len);
    }




}
