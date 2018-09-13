package dao;

import entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> selectAll(
            @Param("start") int start,
            @Param("len") int len
    );

    /**
     * 这是用于处理验证服务的SQL服务
     * @param did 部门唯一标识
     * @param password 密码
     * @return
     */
    Department loginIn(@Param(value = "did") int did, @Param(value = "password") String password);

    /**
     * 添加部门账号，注意在调用此方法后，参数中的did已经有值了
     * @param department
     * @return
     */
    Integer registerDepartment(
            @Param("department") Department department
    );

    /**
     * 删除部门账号
     * @param did
     * @return
     */
    Integer deleteDepartment(
            @Param("did") int did
    );

    /**
     * 更新部门账号，根据其中的did
     * @param department
     * @return
     */
    Integer updateDepartment(
            @Param("department")Department department
    );

    Department findDepartmentByDid(
            @Param("did") int did
    );
}
