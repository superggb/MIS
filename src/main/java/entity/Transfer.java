package entity;

import java.sql.Timestamp;

public class Transfer {
    private int tid;
    private int eid;
    private int oldDepartment;
    private int newDepartment;
    private Timestamp dateTime;

    public Transfer() {
    }

    public Transfer(int tid, int eid, int old_department, int new_department, Timestamp date_time) {
        this.tid = tid;
        this.eid = eid;
        this.oldDepartment = old_department;
        this.newDepartment = new_department;
        this.dateTime = date_time;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(int old_department) {
        this.oldDepartment = old_department;
    }

    public int getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(int new_department) {
        this.newDepartment = new_department;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp date_time) {
        this.dateTime = date_time;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "tid=" + tid +
                ", eid=" + eid +
                ", old_department=" + oldDepartment +
                ", new_department=" + newDepartment +
                ", date_time=" + dateTime +
                '}';
    }
}
