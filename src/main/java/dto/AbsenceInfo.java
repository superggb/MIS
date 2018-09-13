package dto;

import entity.Absence;

import java.sql.Timestamp;

public class AbsenceInfo extends Absence {

    private String name;

    public AbsenceInfo(Absence absence) {
        super(absence.getEid(), absence.getStarttime(), absence.getEndtime(), absence.getDescription());
    }

    public AbsenceInfo(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "AbsenceInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
