package dao;

import org.apache.ibatis.annotations.Param;

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

    Integer addSalaryRecord(
           @Param(value = "eid") int eid,
           @Param(value = "salary") float salary,
           @Param(value = "description") String description
    );
}
