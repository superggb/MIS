package service.impl;

import dao.AbsenceDao;
import entity.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbsenceService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private static final int ASK_FOR_LEAVE = 0; //病名为请假
    private static final int LATE = 1;  //病名为迟到
    private static final int ABSENTEEISM = 2;   //病名为旷工
    @Autowired
    AbsenceDao absenceDao;

    /**
     * 这个方法插入记录
     * @param eid
     * @param starttime
     * @param endtime
     * @param state
     * @param description
     * @return 如果插入成功则返回已插入记录的对象化数据（包括主键）
     */
    @Override
    @Transactional
    public Absence addAbsenceRecord(int eid, Timestamp starttime, Timestamp endtime, int state, String description) {
        Absence absence = new Absence(eid,starttime,endtime,description);
        absence.setState(state);
        absenceDao.addAbsenceRecord(absence);
        return absence;
    }

    @Override
    public Integer updateAbsenceRecord(int aid, int eid, Timestamp starttime, Timestamp endtime, int state, String description){
        return absenceDao.updateAbsenceRecord(aid, eid, starttime, endtime, state, description);
    }
    /**
     * 用于添加请假原因的缺勤记录
     * @param eid
     * @param starttime
     * @param endtime
     * @param description
     * @return
     */
    @Override
    public Absence addAbsenceRecordAskForLeave(int eid, Timestamp starttime, Timestamp endtime, String description) {
        return addAbsenceRecord(eid, starttime, endtime, ASK_FOR_LEAVE, description);
    }

    /**
     * 用于添加迟到原因的缺勤记录
     * @param eid
     * @param starttime
     * @param endtime
     * @param description
     * @return
     */
    @Override
    public Absence addAbsenceRecordLate(int eid, Timestamp starttime, Timestamp endtime, String description) {
        return addAbsenceRecord(eid, starttime, endtime, LATE, description);
    }

    /**
     * 用于添加旷工原因的缺勤记录
     * @param eid
     * @param starttime
     * @param endtime
     * @param description
     * @return
     */
    @Override
    public Absence addAbsenceRecordAbsenteeism(int eid,Timestamp starttime, Timestamp endtime, String description) {
        return addAbsenceRecord(eid, starttime, endtime, ABSENTEEISM, description);
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
