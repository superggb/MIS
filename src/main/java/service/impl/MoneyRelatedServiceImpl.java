package service.impl;

import dao.SalaryDao;
import entity.Salary;
import dto.SalaryShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.MoneyRelatedService;

import java.util.List;

@Service
public class MoneyRelatedServiceImpl implements MoneyRelatedService {

    @Autowired
    SalaryDao salaryDao;    //注意，虽然employee表里也有工资这个项，但是这里不用更改，为了保持程序在web意义上的逻辑第三范式，我在数据库里加了个触发器，使得salary与employee两个表中的salary保持一致

    @Transactional
    @Override
    public Integer addSalaryRecord(int eid, float salary, String description){
        return salaryDao.addSalaryRecord(eid,salary, description);
    }

    @Transactional
    @Override
    public Integer addSalaryRecord(Salary salary) {
        return addSalaryRecord(salary.getEid(), salary.getSalary(), salary.getDescription());
    }

    @Transactional
    @Override
    public Integer updateSalary(int eid, float salary, float bonus, String description) {
        return salaryDao.updateSalary(eid, salary, bonus, description);
    }

    @Transactional
    @Override
    public Integer updateSalary(Salary salary) {
        return updateSalary(salary.getEid(),salary.getSalary(), salary.getBonus(), salary.getDescription());
    }

    /**
     * 员工查询自己的工资信息
     * @param eid 员工唯一标识
     * @param start 从第几条记录开始
     * @param len 一共抽取多少条记录
     * @return
     */
    @Transactional
    @Override
    public List<SalaryShow> findSalaryOrderByDate(int eid, int start, int len) {
        return salaryDao.findSalaryByEidOrderByDate(eid, start, len);
    }

    /**
     * 分页查询所有员工的工资信息
     * @param start 从第几条记录开始
     * @param len 一共抽取多少条记录
     * @return
     */
    @Transactional
    @Override
    public List<SalaryShow> findSalaryOrderByDate(int start, int len) {
        return salaryDao.findSalaryOrderByDate(start, len);
    }


}
