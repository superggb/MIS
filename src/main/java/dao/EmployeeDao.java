package dao;

import entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {

    /**
     * 员工登录验证
     * @param eid 用户唯一标识
     * @param password 用户密码
     * @return 成功则返回插入后的员工信息，否则返回null
     */
    Employee loginIn(@Param(value="eid") int eid, @Param(value="password") String password);

}
