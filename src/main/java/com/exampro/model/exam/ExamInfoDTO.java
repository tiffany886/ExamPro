package com.exampro.model.exam;

public class ExamInfoDTO {
    private String ExamID;
    private String ExamName;
    private String StartTime;
    private String EndTime;
    private String NumberOfExaminees;
    private int examDuration;
    private int ObjectiveScore;
    private int SubjectiveScore;
    private String CreatedBy;
    private int juniorState;
    private int ultimateState;

    // public ExamInfoDTO(Integer examID, String examName, String startTime, String numberOfExaminees, int ultimateDtate, int juniorState) {
    //     ExamID = examID.toString();
    //     ExamName = examName;
    //     StartTime = startTime;
    //     NumberOfExaminees = numberOfExaminees;
    //     this.ultimateDtate = ultimateDtate;
    //     this.juniorState = juniorState;
    //
    // }

// 添加 getters 和 setters
    public ExamInfoDTO(){}

    public ExamInfoDTO(String examID, String examName, String startTime, String endTime, String numberOfExaminees, int examDuration, int objectiveScore, int subjectiveScore, String createdBy, int juniorState, int ultimateState) {
        ExamID = examID;
        ExamName = examName;
        StartTime = startTime;
        EndTime = endTime;
        NumberOfExaminees = numberOfExaminees;
        this.examDuration = examDuration;
        ObjectiveScore = objectiveScore;
        SubjectiveScore = subjectiveScore;
        CreatedBy = createdBy;
        this.juniorState = juniorState;
        this.ultimateState = ultimateState;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
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

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String examID) {
        ExamID = examID;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getNumberOfExaminees() {
        return NumberOfExaminees;
    }

    public void setNumberOfExaminees(String numberOfExaminees) {
        NumberOfExaminees = numberOfExaminees;
    }

    public int getObjectiveScore() {
        return ObjectiveScore;
    }

    public void setObjectiveScore(int objectiveScore) {
        ObjectiveScore = objectiveScore;
    }

    public int getSubjectiveScore() {
        return SubjectiveScore;
    }

    public void setSubjectiveScore(int subjectiveScore) {
        SubjectiveScore = subjectiveScore;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}

