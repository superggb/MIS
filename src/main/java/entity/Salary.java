package entity;

import java.sql.Timestamp;

public class Salary {
    private int sid;
    private int eid;
    private float salary;
    private float fine;
    private float bonus;
    private float tax;
    private float realsalary;
    private Timestamp date_time;
    private String description;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", salary=" + salary +
                ", fine=" + fine +
                ", bonus=" + bonus +
                ", tax=" + tax +
                ", realsalary=" + realsalary +
                ", date_time=" + date_time +
                ", description='" + description + '\'' +
                '}';
    }
}
