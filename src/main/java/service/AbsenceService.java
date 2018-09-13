package service;

import dto.AbsenceInfo;
import entity.Absence;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * 这个类主要用于用于对员工出勤信息做修改，然后完整地返回插入的记录在表里的表现。
 * 实际上也记录了主键值。
 */
public interface AbsenceService {

    /**
     * 添加一条员工缺勤记录
     * @param eid
     * @param starttime
     * @param endtime
     * @param state
     * @param description
     * @return 添加成功则返回刚插入的记录（包括数据库自动生成的自增主键值），否则返回NULL
     */
    @Transactional
    Absence addAbsenceRecord(int eid,
                             Timestamp starttime,
                             Timestamp endtime,
                             int state,
                             String description);

    @Transactional
    Absence addAbsenceRecord(Absence absence);

    @Transactional
    Integer updateAbsenceRecord(int aid, int eid, Timestamp starttime, Timestamp endtime, int state, String description);

    @Transactional
    Integer updateAbsenceRecord(int aid, int eid, Timestamp starttime, int length, int state, String description);

    @Transactional
    Integer updateAbsenceRecord(Absence absence);

    @Transactional
    Absence addAbsenceRecordAskForLeave(int eid, Timestamp starttime, Timestamp endtime, String description);

    @Transactional
    Absence addAbsenceRecordAskForLeave(int eid, Timestamp starttime, int length, String description);

    @Transactional
    Absence addAbsenceRecordAskForLeave(Absence absence);

    @Transactional
    Absence addAbsenceRecordLate(int eid, Timestamp starttime, Timestamp endtime, String description);

    @Transactional
    Absence addAbsenceRecordLate(int eid, Timestamp starttime, int length, String description);

    @Transactional
    Absence addAbsenceRecordLate(Absence absence);

    @Transactional
    Absence addAbsenceRecordAbsenteeism(int eid, Timestamp starttime, Timestamp endtime, String description);

    @Transactional
    Absence addAbsenceRecordAbsenteeism(int eid, Timestamp starttime, int len, String description);

    @Transactional
    Absence addAbsenceRecordAbsenteeism(Absence absence);

    /**
     * 查询did部门从第start条记录开始，缺勤的len条记录（以开始请假的时间为序）
     * @param did
     * @param start
     * @param len
     * @return
     */
    @Transactional
    List<AbsenceInfo> selectAbsenceRecords(int did, int start, int len);

    /**
     * 查询所有部门从第start条记录开始，缺勤的len条记录（以开始请假的时间为序）
     * @param start
     * @param len
     * @return
     */
    @Transactional
    List<AbsenceInfo> selectAbsenceRecords(int start, int len);

    @Transactional
    AbsenceInfo findAbsenceInfoByAid(int aid);

    @Transactional
    Integer deleteAbsenceByAid(int aid);
}
