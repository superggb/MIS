package service.impl;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.SalaryDao;
import dao.TransferDao;
import dto.TransferInfo;
import entity.Department;
import entity.Employee;
import entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AccountRelated;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountRelatedImpl implements AccountRelated {

    private static final String SALARY_STATE_DESCRIPTION = "新增员工工资";
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private TransferDao transferDao;

    /**
     * 添加员工
     * @param name 员工姓名
     * @param password 员工基本工资
     * @param salary  员工密码（30个字符以内，限字母数字以及下划线）
     * @param did   外键，表示部门
     * @return
     */
    @Override
    @Transactional
    public Employee register(String name, String password, float salary, int did) {
            Employee employee = new Employee(name, salary,password);
            employeeDao.addEmployee(employee, 11001);
            //还要相应的修改salary表
            salaryDao.addSalaryRecord(employee.getEid(), employee.getSalary(), SALARY_STATE_DESCRIPTION);
            return employee;
    }

    @Transactional
    @Override
    public Employee register(Employee employee) {
        return register(employee.getName(), employee.getPassword(), employee.getSalary(), employee.getDepartment().getDid());
    }

    @Override
    public Employee loginEmployee(int eid, String password) {
        try {
            Employee employee = employeeDao.loginIn(eid, password);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department loginDepartment(int did, String password) {
        try {
            Department department = departmentDao.loginIn(did, password);
            return department;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 更改雇员密码
     * @param eid
     * @param newPassword
     * @return
     */
    @Transactional
    @Override
    public Integer updateEmployeePassword(int eid, String name, String oldPassword, String newPassword){
        return employeeDao.updateEmployeePassword(eid, name, oldPassword,newPassword);
    }

    /**
     * 员工调度信息的修改
     * @param eid
     * @param kind
     * @param oldDid
     * @param newDid
     * @return
     */
    @Override
    @Transactional
    public Integer updateEmployeeInfo(int eid, int kind, int oldDid, int newDid) {
        employeeDao.updateEmployeeDid(eid, oldDid,newDid);
        transferDao.addTransferRecord(eid, oldDid, newDid);
        return null;
    }

    /**
     * 对员工信息的删除
     * @param eid
     * @return
     */
    @Override
    @Transactional
    public Integer deleteEmployee(int eid){
        return employeeDao.deleteEmployee(eid);
    }

    /**
     * 更新员工调度信息
     * @param tid
     * @param eid
     * @param old_department
     * @param new_department
     * @return
     */
    @Override
    @Transactional
    public Integer updateTransfer(int tid, int eid, int old_department, int new_department){
        return transferDao.updateTransferRecord(tid, eid,old_department, new_department);
    }

    @Transactional
    @Override
    public Integer updateTransfer(Transfer transfer) {
        return updateTransfer(transfer.getTid(), transfer.getEid(), transfer.getOld_department(), transfer.getNew_department());
    }

    /**
     * 这个方法用于向部门表添加一条数据
     * @param name
     * @param password
     * @return
     */
    @Transactional
    @Override
    public Department register(String name, String password){
        Department department = new Department(name, password);
        departmentDao.registerDepartment(department);
        return department;
    }

    @Transactional
    @Override
    public Department register(Department department) {
        return register(department.getName(), department.getPassword());
    }

    /**
     * 删除一条部门账号记录信息
     * @param did
     * @return
     */
    @Transactional
    @Override
    public Integer deleteDepartment(int did){
        return departmentDao.deleteDepartment(did);
    }

    /**
     * 更新一个部门记录的部门信息,非对象化模式
     * @param did
     * @param newName
     * @param newPassword
     * @return
     */
    @Transactional
    @Override
    public Integer updateDepartment(int did, String newName, String newPassword){
        return departmentDao.updateDepartment(new Department(did, newName, newPassword));
    }

    /**
     * 记录员工调度信息
     * @param start
     * @param len
     * @return
     */
    @Transactional
    @Override
    public List<TransferInfo> findTransferInfoOrderByDate(int start, int len){
        List<Transfer> transfers = transferDao.selectTransferOrderByTime(start, len);
        List<TransferInfo> transferInfos = new ArrayList<>();
        for (Transfer transfer:
             transfers) {
            transferInfos.add(new TransferInfo(transfer));
        }
        return transferInfos;
    }

    /**
     * 查找从第start条记录开始，到第start+len条的所有记录
     * @param start
     * @param len
     * @return
     */
    @Transactional
    @Override
    public List<Department> findDepartment(int start, int len){
        return departmentDao.selectAll(start, len);
    }
}
