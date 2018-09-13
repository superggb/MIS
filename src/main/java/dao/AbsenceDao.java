package dao;

import dto.AbsenceInfo;
import entity.Absence;
import entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AbsenceDao {

    /**
     * 这个方法用于添加缺勤记录
     * @return
     */
    Integer addAbsenceRecord( @Param("add_absence") Absence absence);


    /**
     * 见名知义
     * @param did
     * @param start
     * @param len
     * @return
     */
    List<Absence> selectAbsenceRecordsByDidOrderByStartTime(
            @Param(value = "did") int did,
            @Param(value = "start") int start,
            @Param(value = "len") int len
    );

    List<Absence> selectAbsenceRecordsOrderByStartTime(
            @Param(value = "start") int start,
            @Param(value = "len") int len
    );

    /**
     * 更新一条缺勤信息记录
     * @param aid
     * @param eid
     * @param starttime
     * @param endtime
     * @param state
     * @param description
     * @return
     */
    Integer updateAbsenceRecord(
            @Param("aid") int aid,
            @Param("eid") int eid,
            @Param("starttime") Timestamp starttime,
            @Param("endtime") Timestamp endtime,
            @Param("state") int state,
            @Param("description") String description
    );

    public AbsenceInfo findAbsenceInfoByAid(
            @Param("aid") int aid
    );

    public Integer deleteAbsenceByAid(
            @Param("aid") int aid
    );
}
