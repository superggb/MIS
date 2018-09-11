package dto;

import java.sql.Timestamp;

/**
 * 这个类主要是用于展示员工个人工资的
 */
public class SalaryShow {
    private String name;
    private Timestamp date;
    private float salary;
    private float fine;
    private float bonus;
    private float tax;
    private float realsalary;

    public SalaryShow() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getRealsalary() {
        return realsalary;
    }

    public void setRealsalary(float realsalary) {
        this.realsalary = realsalary;
    }

    @Override
    public String toString() {
        return "SalaryShow{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", salary=" + salary +
                ", fine=" + fine +
                ", bonus=" + bonus +
                ", tax=" + tax +
                ", realsalary=" + realsalary +
                '}';
    }
}
