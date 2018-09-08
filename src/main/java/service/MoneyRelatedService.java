package service;

import model.SalaryShow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoneyRelatedService {

    @Transactional
    Integer updateSalary(int eid, float salary,float bonus, String description);

    @Transactional
    List<SalaryShow> findSalaryOrderByDate(int eid, int start, int len);

    @Transactional
    List<SalaryShow> findSalaryOrderByDate(int start, int len);
}
