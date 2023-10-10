package com.exampro.model.paper;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目表
 */
public class Questionpool implements Serializable {
    /**
     * 题目ID
     *
     */
    private Integer questionId;

    /**
     * 题目类型
     *
     */
    private String questionType;
    /**
     * 题目描述
     *
     */
    private String questionDescription;
    /**
     *
     * 所属用户
     * @param questionid
     */
    private Integer userId;
    /**
     * 问题答案
     * @return
     */
    private String questionAnswer;

    /**
     * 创建时间
     *
     */
    private Date createTime;

    private Integer questionScore;

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setQuestionScore(Integer questionScore) {
        this.questionScore = questionScore;
    }

    public Questionpool(Integer questionId, String questionType, String questionDescription, Integer userId, String questionAnswer, Date createTime, Integer questionScore) {
        this.questionId = questionId;
        this.questionType = questionType;
        this.questionDescription = questionDescription;
        this.userId = userId;
        this.questionAnswer = questionAnswer;
        this.createTime = createTime;
        this.questionScore = questionScore;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getQuestionScore() {
        return questionScore;
    }

    public Questionpool(String questionType, String questionDescription, Integer userId, String questionAnswer, Integer questionScore) {
        this.questionType = questionType;
        this.questionDescription = questionDescription;
        this.userId = userId;
        this.questionAnswer = questionAnswer;
        this.questionScore = questionScore;
    }
}