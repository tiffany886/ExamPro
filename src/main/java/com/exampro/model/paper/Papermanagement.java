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
     * 创建人ID
     *
     */
    private Integer userId;

    /**
     * 终极考核状态
     *
     */
    private int ultimateState;

    /**
     * 初极考核状态
     *
     */
    private int juniorState;

    public Papermanagement(String paperName, Integer objectiveScore, Integer totalScore, Integer subjectiveScore, Integer userId) {
        this.paperName = paperName;
        this.objectiveScore = objectiveScore;
        this.totalScore = totalScore;
        this.subjectiveScore = subjectiveScore;
        this.userId = userId;
    }

    public Papermanagement(Integer paperId, String paperName, Integer objectiveScore, Integer totalScore, Integer subjectiveScore, Integer userId, int ultimateState, int juniorState) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.objectiveScore = objectiveScore;
        this.totalScore = totalScore;
        this.subjectiveScore = subjectiveScore;
        this.userId = userId;
        this.ultimateState = ultimateState;
        this.juniorState = juniorState;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Papermanagement{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", objectiveScore=" + objectiveScore +
                ", totalScore=" + totalScore +
                ", subjectiveScore=" + subjectiveScore +
                ", userId=" + userId +
                ", ultimateState=" + ultimateState +
                ", juniorState=" + juniorState +
                '}';
    }
}