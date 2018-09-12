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

    /**
     * 添加员工，注意事务处理，要结合salary进行修改
     * @return 返回的是
     */
    Integer addEmployee(@Param(value = "add_employee") Employee employee, @Param("did") int did);

    /**
     * 更改员工密码
     * @return
     */
    Integer updateEmployeePassword(@Param("eid") int eid,
                                   @Param("name") String name,
                                   @Param("oldPassword") String oldPassword,
                                   @Param("newPassword") String newPassword);

    /**
     * 更改员工部门信息
     * @param eid
     * @param oldDid
     * @param newDid
     * @return
     */
    Integer updateEmployeeDid(@Param("eid") int eid,
                              @Param("oldDid") int oldDid,
                              @Param("newDid") int newDid);

    /**
     * 删除一个员工
     * @param eid
     * @return
     */
    Integer deleteEmployee(
            @Param("eid") int eid
    );

    String findNameByEid(
            @Param("eid") int eid
    );

    Employee findEmployeeByEid(
            @Param("eid") int eid
    );
}
