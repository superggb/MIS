package dao;

import entity.Absence;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface AbsenceDao {

    /**
     * 这个方法用于添加缺勤记录
     * @return
     */
    Integer addAbsenceRecord( @Param("add_absence") Absence absence);


}
