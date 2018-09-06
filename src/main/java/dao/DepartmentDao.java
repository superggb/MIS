package dao;

import entity.Department;

import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> selectAll();
}
