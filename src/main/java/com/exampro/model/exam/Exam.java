package com.exampro.model.exam;

import java.io.Serializable;
import java.util.Date;

public class Exam implements Serializable {
        private int examID;
        private String examName;
        private String examDescription;
        private int paperID;
        private Date startTime;
        private Date endTime;
        private int examDuration;
        private int numberOfExaminees;
        private int userID;
        private int ultimateState;
        private int juniorState;
        // 在这里添加构造函数、Getter和Setter方法


    public Exam(int examID, String examName, String examDescription, int paperID, Date startTime, Date endTime, int examDuration, int numberOfExaminees, int userID, int ultimateState, int juniorState) {
        this.examID = examID;
        this.examName = examName;
        this.examDescription = examDescription;
        this.paperID = paperID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDuration = examDuration;
        this.numberOfExaminees = numberOfExaminees;
        this.userID = userID;
        this.ultimateState = ultimateState;
        this.juniorState = juniorState;
    }

    public int getUltimateState() {
        return ultimateState;
    }

    public void setUltimateState(int ultimateState) {
        this.ultimateState = ultimateState;
    }

    public int getJuniorState() {
        return juniorState;
    }

    public void setJuniorState(int juniorState) {
        this.juniorState = juniorState;
    }

    public Exam(int examID, String examName, String examDescription, int paperID, Date startTime, Date endTime, int examDuration, int numberOfExaminees, int userID) {
        this.examID = examID;
        this.examName = examName;
        this.examDescription = examDescription;
        this.paperID = paperID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDuration = examDuration;
        this.numberOfExaminees = numberOfExaminees;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", examName='" + examName + '\'' +
                ", examDescription='" + examDescription + '\'' +
                ", paperID=" + paperID +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", examDuration=" + examDuration +
                ", numberOfExaminees=" + numberOfExaminees +
                ", userID=" + userID +
                '}';
    }

    public int getExamID() {
            return examID;
        }

        public void setExamID(int examID) {
            this.examID = examID;
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

        public int getPaperID() {
            return paperID;
        }

        public void setPaperID(int paperID) {
            this.paperID = paperID;
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

        public int getNumberOfExaminees() {
            return numberOfExaminees;
        }

        public void setNumberOfExaminees(int numberOfExaminees) {
            this.numberOfExaminees = numberOfExaminees;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }
    }
