package com.exampro.model.invigilate;

import java.util.Date;

/**
 * @Auther pluto
 * @Date 2023/10/27
 */
public class proctoring_record {

    int RecordID;
    int ExamineeID;
    int ExamID;
    int ProctorID;
    String IssueContent;
    Date Time;
    int SenderID;

    public proctoring_record(int examineeID, int examID, int proctorID, String issueContent, int senderID) {
        ExamineeID = examineeID;
        ExamID = examID;
        ProctorID = proctorID;
        IssueContent = issueContent;
        SenderID = senderID;
    }

    public proctoring_record(int recordID, int examineeID, int examID, int proctorID, String issueContent, Date time, int senderID) {
        RecordID = recordID;
        ExamineeID = examineeID;
        ExamID = examID;
        ProctorID = proctorID;
        IssueContent = issueContent;
        Time = time;
        SenderID = senderID;
    }

    @Override
    public String toString() {
        return "proctoring_record{" +
                "RecordID=" + RecordID +
                ", ExamineeID=" + ExamineeID +
                ", ExamID=" + ExamID +
                ", ProctorID=" + ProctorID +
                ", IssueContent='" + IssueContent + '\'' +
                ", Time=" + Time +
                ", SenderID=" + SenderID +
                '}';
    }

    public int getRecordID() {
        return RecordID;
    }

    public void setRecordID(int recordID) {
        RecordID = recordID;
    }

    public int getExamineeID() {
        return ExamineeID;
    }

    public void setExamineeID(int examineeID) {
        ExamineeID = examineeID;
    }

    public int getExamID() {
        return ExamID;
    }

    public void setExamID(int examID) {
        ExamID = examID;
    }

    public int getProctorID() {
        return ProctorID;
    }

    public void setProctorID(int proctorID) {
        ProctorID = proctorID;
    }

    public String getIssueContent() {
        return IssueContent;
    }

    public void setIssueContent(String issueContent) {
        IssueContent = issueContent;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public int getSenderID() {
        return SenderID;
    }

    public void setSenderID(int senderID) {
        SenderID = senderID;
    }
}
