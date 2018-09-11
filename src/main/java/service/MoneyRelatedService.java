package service;

import entity.Salary;
import dto.SalaryShow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoneyRelatedService {

    @Transactional
    Integer addSalaryRecord(int eid, float salary, String description);

    @Transactional
    Integer addSalaryRecord(Salary salary);

    @Transactional
    Integer updateSalary(int eid, float salary,float bonus, String description);

    @Transactional
    Integer updateSalary(Salary salary);

    @Transactional
    List<SalaryShow> findSalaryOrderByDate(int eid, int start, int len);

    @Transactional
    List<SalaryShow> findSalaryOrderByDate(int start, int len);
}
