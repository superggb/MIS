package dao;

import entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> selectAll();

    /**
     * 这是用于处理验证服务的SQL服务
     * @param did 部门唯一标识
     * @param password 密码
     * @return
     */
    Department loginIn(@Param(value = "did") int did, @Param(value = "password") String password);
}
