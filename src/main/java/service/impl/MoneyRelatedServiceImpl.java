package service.impl;

import dao.SalaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.MoneyRelatedService;

@Service
public class MoneyRelatedServiceImpl implements MoneyRelatedService {

    @Autowired
    SalaryDao salaryDao;

    @Override
    public Integer updateSalary(int eid, float salary, float bonus, String description) {
        return salaryDao.updateSalary(eid, salary, bonus, description);
    }
}
