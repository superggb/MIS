package service;

import dto.TransferInfo;
import entity.Department;
import entity.Employee;
import entity.Transfer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
* 这个接口用于接手处理涉及到账号的业务。
* 比如：登陆、注册、更改密码等操作。
 */
public interface AccountRelated {

    /**
     * 用户注册
     * @param name 员工姓名
     * @param password 员工基本工资
     * @param salary  员工密码（30个字符以内，限字母数字以及下划线）
     * @param did   外键，表示部门
     * @return 1代表插入成功，2代表账号已被注册，3代表输入的数据不满足数据库要求
     * 注意：数据库设计人员除外键约束外并未在数据库内考虑以上所有限制因素，请编码人员注意。
     */
    @Transactional
    Employee register(String name, String password, float salary, int did);

    @Transactional
    Employee register(Employee employee);

    /**
     * 这个方法用于处理普通员工的登录认证工作
     * @param eid 员工唯一标识
     * @param password 员工密码
     * @return 登录成功则返回employee表对应行的数据（账号密码正确），为null表示账号密码不存在或者错误
     */
    @Transactional
    Employee loginEmployee(int eid, String password);

    /**
     * 这个方法用于处理部门管理账号的登录认证工作
     * @param did 部门唯一标识
     * @param password  密码
     * @return 登录成功则返回employee表对应行的数据（账号密码正确），为null表示账号密码不存在或者错误
     */
    @Transactional
    Department loginDepartment(int did, String password);

    @Transactional
    Integer updateEmployeePassword(int eid, String name, String oldPassword, String newPassword);

    /**
     * 更改员工基本信息，属于员工部门流动
     * @param eid
     * @param kind
     * @param oldDid
     * @param newDid
     * @return
     */
    @Transactional
    Integer updateEmployeeInfo(int eid, int kind, int oldDid, int newDid);

    @Transactional
    Integer deleteEmployee(int eid);

    @Transactional
    Integer updateTransfer(int tid, int eid, int old_department, int new_department);

    @Transactional
    Integer updateTransfer(Transfer transfer);

    @Transactional
    Department register(String name, String password);

    @Transactional
    Department register(Department department);

    @Transactional
    Integer deleteDepartment(int did);

    @Transactional
    Integer updateDepartment(int did, String newName, String newPassword);

    List<TransferInfo> findTransferInfoOrderByDate(int start, int len);

    @Transactional
    List<Department> findDepartment(int start, int len);
}
