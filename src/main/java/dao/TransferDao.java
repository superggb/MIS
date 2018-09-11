package dao;

import entity.Transfer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferDao {

    /**
     * 添加员工流动信息
     * @param eid
     * @param oldDid
     * @param newDid
     * @return
     */
    Integer addTransferRecord(@Param("eid") int eid,
                              @Param("old_department") int oldDid,
                              @Param("new_department") int newDid
                              );


    /**
     * 更新员工调度信息
     * @param tid
     * @param eid
     * @param old_department
     * @param new_department
     * @return
     */
    Integer updateTransferRecord(
            @Param("tid") int tid,
            @Param("eid") int eid,
            @Param("old_department") int old_department,
            @Param("new_department") int new_department
    );

    /**
     * 按时间顺序取出从第start条记录开始的len条记录
     * @param start
     * @param len
     * @return
     */
    List<Transfer> selectTransferOrderByTime(
            @Param("start") int start,
            @Param("len") int len
    );



}