package entity;

import java.sql.Timestamp;

public class Absence {
    private int aid;
    private int eid;
    private Timestamp starttime;
    private Timestamp endtime;
    private int state;
    private String description;

    public Absence() {
    }

    public Absence(int eid, Timestamp starttime, Timestamp endtime, String description) {
        this.eid = eid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.description = description;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "aid=" + aid +
                ", eid=" + eid +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", state=" + state +
                ", description='" + description + '\'' +
                '}';
    }
}
