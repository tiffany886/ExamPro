package com.exampro.model.paper;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 试卷管理表
 */
public class Papermanagement implements Serializable {
    public Papermanagement(){}
    /**
     * 试卷ID
     *
     */
    private Integer paperId;

    /**
     * 试卷名称
     *
     */
    private String paperName;

    /**
     * 客观题分数
     *
     */
    private Integer objectiveScore;

    /**
     * 总分
     *
     */
    private Integer totalScore;

    /**
     * 主观题分数
     *
     */
    private Integer subjectiveScore;

    /**
     * 考试开始时间
     *
     */
    private Date startTime;

    /**
     * 考试结束时间
     *
     */
    private Date endTime;

    /**
     * 考试人数
     *
     */
    private Integer numberOfExaminees;

    /**
     * 创建人ID
     *
     */
    private Integer userId;

    /**
     *考试时间
     */
    private Integer duration;

    private int ultimateState;
    private int juniorState;

    public Papermanagement(Integer paperId, String paperName, Integer objectiveScore, Integer totalScore, Integer subjectiveScore, Date startTime, Date endTime, Integer numberOfExaminees, Integer userId, Integer duration, int ultimateState, int juniorState) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.objectiveScore = objectiveScore;
        this.totalScore = totalScore;
        this.subjectiveScore = subjectiveScore;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfExaminees = numberOfExaminees;
        this.userId = userId;
        this.duration = duration;
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

    public Papermanagement(Integer paperId) {
        this.paperId = paperId;
    }

    public Papermanagement(String paperName, Integer objectiveScore, Integer subjectiveScore, Date startTime, Integer numberOfExaminees, Integer userId, Integer duration) {
        this.paperName = paperName;
        this.objectiveScore = objectiveScore;
        this.subjectiveScore = subjectiveScore;
        this.startTime = startTime;
        this.numberOfExaminees = numberOfExaminees;
        this.userId = userId;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Papermanagement{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", objectiveScore=" + objectiveScore +
                ", totalScore=" + totalScore +
                ", subjectiveScore=" + subjectiveScore +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", numberOfExaminees=" + numberOfExaminees +
                ", userId=" + userId +
                ", duration=" + duration +
                '}';
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getObjectiveScore() {
        return objectiveScore;
    }

    public void setObjectiveScore(Integer objectiveScore) {
        this.objectiveScore = objectiveScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getSubjectiveScore() {
        return subjectiveScore;
    }

    public void setSubjectiveScore(Integer subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
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

    public Integer getNumberOfExaminees() {
        return numberOfExaminees;
    }

    public void setNumberOfExaminees(Integer numberOfExaminees) {
        this.numberOfExaminees = numberOfExaminees;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Papermanagement(Integer paperId, String paperName, Integer objectiveScore, Integer totalScore, Integer subjectiveScore, Date startTime, Date endTime, Integer numberOfExaminees, Integer userId, Integer duration) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.objectiveScore = objectiveScore;
        this.totalScore = totalScore;
        this.subjectiveScore = subjectiveScore;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfExaminees = numberOfExaminees;
        this.userId = userId;
        this.duration = duration;
    }
}