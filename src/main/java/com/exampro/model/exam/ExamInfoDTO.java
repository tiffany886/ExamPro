package com.exampro.model.exam;

public class ExamInfoDTO {
    private String ExamID;
    private String ExamName;
    private String StartTime;
    private String EndTime;
    private String NumberOfExaminees;
    private int ObjectiveScore;
    private int SubjectiveScore;
    private String CreatedBy;

    // 添加 getters 和 setters


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

