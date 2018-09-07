package service.impl;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.SalaryDao;
import dao.TransferDao;
import entity.Department;
import entity.Employee;
import entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AccountRelated;
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
    public Employee register( String name, String password, float salary, int did) {
            Employee employee = new Employee(name, salary,password);
            employeeDao.addEmployee(employee, 11001);
            //还要相应的修改salary表
            salaryDao.addSalaryRecord(employee.getEid(), employee.getSalary(), SALARY_STATE_DESCRIPTION);
            return employee;
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

    @Override
    @Transactional
    public Integer updateEmployeeInfo(int eid, int kind, int oldDid, int newDid) {
        employeeDao.updateEmployeeDid(eid, oldDid,newDid);
        transferDao.addTransferRecord(eid, oldDid, newDid);
        return null;
    }
}
