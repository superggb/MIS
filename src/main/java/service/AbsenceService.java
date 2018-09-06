package service;

import entity.Absence;

import java.sql.Timestamp;

/**
 * 这个类主要用于用于对员工出勤信息做修改，然后完整地返回插入的记录在表里的表现。
 * 实际上也记录了主键值。
 */
public interface AbsenceService {
    Absence addAbsenceRecord(int eid,
                             Timestamp starttime,
                             Timestamp endtime,
                             int state,
                             String description);
}
