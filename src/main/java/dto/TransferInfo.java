package dto;

import entity.Transfer;

import java.sql.Timestamp;

public class TransferInfo extends Transfer {
    private String transferInfo;
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
        this.setDate_time(transfer.getDate_time());
        this.setNew_department(transfer.getNew_department());
        this.setOld_department(transfer.getOld_department());
        this.setTid(transfer.getTid());
        if (-1 == this.getOld_department() && -1 != this.getNew_department()){
            this.transferInfo = KIND_TRANSFER_NEWMAN;
        } else if (-1 != getOld_department() && -1 != getNew_department()){
            this.transferInfo = KIND_TRANSFER_MOBILIZE;
        } else if (-1 != getOld_department() && -1 == getNew_department()){
            this.transferInfo = KIND_TRANSFER_DISMISS;
        } else if (-1 != getOld_department() && 0 == getNew_department()){
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

    @Override
    public String toString() {
        return super.toString() + "TransferInfo{" +
                "transferInfo='" + transferInfo + '\'' +
                '}';
    }
}
