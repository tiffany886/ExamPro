package com.exampro.model.exam;

import java.io.Serializable;
import java.util.Date;

public class Exam implements Serializable {
    /**
     * 考试ID
     */
    private Integer examId;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 考试描述
     */
    private String examDescription;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 考试时长
     */
    private Integer duration;

    public Exam(Integer examId, String examName, String examDescription, Date startTime, Date endTime, Integer duration) {
        this.examId = examId;
        this.examName = examName;
        this.examDescription = examDescription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", examDescription='" + examDescription + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                '}';
    }
}


