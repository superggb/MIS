package service.impl;

import dao.SalaryDao;
import model.SalaryShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.MoneyRelatedService;

import java.util.List;

@Service
public class MoneyRelatedServiceImpl implements MoneyRelatedService {

    @Autowired
    SalaryDao salaryDao;

    @Transactional
    @Override
    public Integer updateSalary(int eid, float salary, float bonus, String description) {
        return salaryDao.updateSalary(eid, salary, bonus, description);
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
