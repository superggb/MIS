package entity;

import java.sql.Timestamp;

public class Transfer {
    private int tid;
    private int eid;
    private int old_department;
    private int new_department;
    private Timestamp date_time;

    private static final String KIND_TRANSFER_DISMISS = "辞退";
    private static final String KIND_TRANSFER_MOBILIZE = "调动";
    private static final String KIND_TRANSFER_RETIRE = "退休";

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

    public int getOld_department() {
        return old_department;
    }

    public void setOld_department(int old_department) {
        this.old_department = old_department;
    }

    public int getNew_department() {
        return new_department;
    }

    public void setNew_department(int new_department) {
        this.new_department = new_department;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "tid=" + tid +
                ", eid=" + eid +
                ", old_department=" + old_department +
                ", new_department=" + new_department +
                ", date_time=" + date_time +
                '}';
    }
}
