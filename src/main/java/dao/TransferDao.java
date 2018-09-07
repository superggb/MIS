package dao;

import org.apache.ibatis.annotations.Param;

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
}
