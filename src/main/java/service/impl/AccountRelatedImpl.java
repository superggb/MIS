package service.impl;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AccountRelated;

@Service
public class AccountRelatedImpl implements AccountRelated {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Integer register(int eid, String name, String password, float salary, int did) {
        return null;
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
}
