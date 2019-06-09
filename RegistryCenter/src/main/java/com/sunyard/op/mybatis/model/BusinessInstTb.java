package com.sunyard.op.mybatis.model;

public class BusinessInstTb {
    private String taskId;

    private String busId;

    private int busVer;

    private String sceneCode;

    private String organNo;

    private String startUserId;

    private String startDate;

    private String endDate;

    private int priority;

    private int adjustPriority;

    private String taskState;

    private String bankNo;

    private String systemNo;

    private String docId;

    private String pointBitmap;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId == null ? null : busId.trim();
    }

    public int getBusVer() {
        return busVer;
    }

    public void setBusVer(int busVer) {
        this.busVer = busVer;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode == null ? null : sceneCode.trim();
    }

    public String getOrganNo() {
        return organNo;
    }

    public void setOrganNo(String organNo) {
        this.organNo = organNo == null ? null : organNo.trim();
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId == null ? null : startUserId.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getAdjustPriority() {
        return adjustPriority;
    }

    public void setAdjustPriority(int adjustPriority) {
        this.adjustPriority = adjustPriority;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState == null ? null : taskState.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getPointBitmap() {
        return pointBitmap;
    }

    public void setPointBitmap(String pointBitmap) {
        this.pointBitmap = pointBitmap == null ? null : pointBitmap.trim();
    }

    @Override
    public String toString() {
        return "BusinessInstTb{" +
                "taskId='" + taskId + '\'' +
                ", busId='" + busId + '\'' +
                ", busVer=" + busVer +
                ", sceneCode='" + sceneCode + '\'' +
                ", organNo='" + organNo + '\'' +
                ", startUserId='" + startUserId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", priority=" + priority +
                ", adjustPriority=" + adjustPriority +
                ", taskState='" + taskState + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", systemNo='" + systemNo + '\'' +
                ", docId='" + docId + '\'' +
                ", pointBitmap='" + pointBitmap + '\'' +
                '}';
    }
}