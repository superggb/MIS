package dao;

import dto.SalaryShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryDao {

    /**
     * 更改员工基本工资信息
     * @param eid
     * @param salary
     * @param bonus
     * @param description
     * @return
     */
    Integer updateSalary(
            @Param(value = "eid") int eid,
            @Param(value = "salary") float salary,
            @Param(value = "bonus") float bonus,
            @Param(value = "description") String description
    );

    /**
     * 增加员工工资信息记录
     * @param eid
     * @param salary
     * @param description
     * @return
     */
    Integer addSalaryRecord(
           @Param(value = "eid") int eid,
           @Param(value = "salary") float salary,
           @Param(value = "description") String description
    );

    /**
     * 搜索按照时间顺序，搜索某一员工的从第start条记录开始的len条记录
     * @param eid
     * @param start
     * @param len
     * @return
     */
    List<SalaryShow> findSalaryByEidOrderByDate(
            @Param("eid") int eid,
            @Param("start") int start,
            @Param("len") int len
    );

    /**
     * 搜索按照时间顺序，搜索所有员工的从第start条记录开始的len条记录
     * @param start
     * @param len
     * @return
     */
    List<SalaryShow> findSalaryOrderByDate(
            @Param("start") int start,
            @Param("len") int len
    );

    int updateEmployeeSalary(@Param("eid")int eid,@Param("salary")float salary);
}
