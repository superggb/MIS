package dao;

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
}
