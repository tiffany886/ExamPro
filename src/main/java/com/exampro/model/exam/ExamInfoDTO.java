package com.exampro.model.exam;

public class ExamInfoDTO {
    private String PaperId;
    private String ExamName;
    private String StartTime;
    private String EndTime;
    private String NumberOfExaminees;
    private int ObjectiveScore;
    private int SubjectiveScore;
    private String CreatedBy;

    // 添加 getters 和 setters

    @Override
    public String toString() {
        return "ExamInfoDTO{" +
                "PaperId='" + PaperId + '\'' +
                ", ExamName='" + ExamName + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", NumberOfExaminees='" + NumberOfExaminees + '\'' +
                ", ObjectiveScore=" + ObjectiveScore +
                ", SubjectiveScore=" + SubjectiveScore +
                ", CreatedBy='" + CreatedBy + '\'' +
                '}';
    }

    public String getPaperId() {
        return PaperId;
    }

    public void setPaperId(String paperId) {
        PaperId = paperId;
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

