package service;

import entity.Absence;

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
    Absence addAbsenceRecord(int eid,
                             Timestamp starttime,
                             Timestamp endtime,
                             int state,
                             String description);

    /**
     * 查询did部门从第start条记录开始，缺勤的len条记录（以开始请假的时间为序）
     * @param did
     * @param start
     * @param len
     * @return
     */
    List<Absence> selectAbsenceRecords(int did, int start, int len);

    /**
     * 查询所有部门从第start条记录开始，缺勤的len条记录（以开始请假的时间为序）
     * @param start
     * @param len
     * @return
     */
    List<Absence> selectAbsenceRecords(int start, int len);
}
