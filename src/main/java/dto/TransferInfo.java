package dto;

import entity.Transfer;

import java.sql.Timestamp;

public class TransferInfo extends Transfer {
    private String transferInfo;
    private String name;
    private static final String KIND_TRANSFER_DISMISS = "辞退";
    private static final String KIND_TRANSFER_MOBILIZE = "调动";
    private static final String KIND_TRANSFER_RETIRE = "退休";
    private static final String KIND_TRANSFER_NEWMAN = "新员工";
    private static final String KIND_TRANSFER_WRONG = "错误";

    public TransferInfo(int tid, int eid, int old_department, int new_department, Timestamp date_time) {
        super(tid, eid, old_department, new_department, date_time);
        if (-1 == old_department && -1 != new_department){
            this.transferInfo = KIND_TRANSFER_NEWMAN;
        } else if (-1 != old_department && -1 != new_department){
            this.transferInfo = KIND_TRANSFER_MOBILIZE;
        } else if (-1 != old_department && -1 == new_department){
            this.transferInfo = KIND_TRANSFER_DISMISS;
        } else if (-1 != old_department && 0 == new_department){
            this.transferInfo = KIND_TRANSFER_RETIRE;
        } else {
            this.transferInfo = KIND_TRANSFER_WRONG;
        }
    }

    public TransferInfo(Transfer transfer){
        this.setEid(transfer.getEid());
        this.setDateTime(transfer.getDateTime());
        this.setNewDepartment(transfer.getNewDepartment());
        this.setOldDepartment(transfer.getOldDepartment());
        this.setTid(transfer.getTid());
        if (-1 == this.getOldDepartment() && -1 != this.getNewDepartment()){
            this.transferInfo = KIND_TRANSFER_NEWMAN;
        } else if (-1 != getOldDepartment() && -1 != getNewDepartment()){
            this.transferInfo = KIND_TRANSFER_MOBILIZE;
        } else if (-1 != getOldDepartment() && -1 == getNewDepartment()){
            this.transferInfo = KIND_TRANSFER_DISMISS;
        } else if (-1 != getOldDepartment() && 0 == getNewDepartment()){
            this.transferInfo = KIND_TRANSFER_RETIRE;
        } else {
            this.transferInfo = KIND_TRANSFER_WRONG;
        }
    }

    public String getTransferInfo() {
        return transferInfo;
    }

    public void setTransferInfo(String transferInfo) {
        this.transferInfo = transferInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "TransferInfo{" +
                "transferInfo='" + transferInfo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
