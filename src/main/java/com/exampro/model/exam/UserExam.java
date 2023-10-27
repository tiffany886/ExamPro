package com.exampro.model.exam;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 *@Author zhhh
 *@Date 2023/10/27
 */
public class UserExam {
    private int examId;
    private String examName;
    private String ExamDescription;
    private Date startTime;
    private Date endTime;
    private int examDuration;
    private int paperId;
    private int NumberOfExaminees;

    public UserExam(int examId, String examName, String examDescription, Date startTime, Date endTime, int examDuration, int paperId, int numberOfExaminees) {
        this.examId = examId;
        this.examName = examName;
        ExamDescription = examDescription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDuration = examDuration;
        this.paperId = paperId;
        NumberOfExaminees = numberOfExaminees;
    }

    public int getNumberOfExaminees() {
        return NumberOfExaminees;
    }

    public void setNumberOfExaminees(int numberOfExaminees) {
        NumberOfExaminees = numberOfExaminees;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public UserExam(int examId, String examName, String examDescription, Date startTime, Date endTime, int examDuration, int paperId) {
        this.examId = examId;
        this.examName = examName;
        ExamDescription = examDescription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDuration = examDuration;
        this.paperId = paperId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDescription() {
        return ExamDescription;
    }

    public void setExamDescription(String examDescription) {
        ExamDescription = examDescription;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public UserExam(int examId, String examName, String examDescription, Date startTime, Date endTime, int examDuration) {
        this.examId = examId;
        this.examName = examName;
        ExamDescription = examDescription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDuration = examDuration;
    }
}
