package com.exampro.model.paper;

import io.swagger.models.auth.In;

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
     * 创建时间
     *
     */
    private Date createTime;

    /**
     * 题目描述
     *
     */
    private String questionDescription;

    /**
     * 问题答案
     * @return
     */
    private String questionAnswer;

    /**
     *
     * 所属用户
     * @param questionid
     */
    private Integer userId;

    public Questionpool(String questionType, String questionDescription, String questionAnswer, Integer userId) {
        this.questionType = questionType;
        this.questionDescription = questionDescription;
        this.questionAnswer = questionAnswer;
        this.userId = userId;
    }

    public Questionpool(Integer questionid, String questiontype, String questiondescription, Integer userId , String questionanswer, Date createtime) {
        this.questionId = questionid;
        this.questionType = questiontype;
        this.createTime = createtime;
        this.questionDescription = questiondescription;
        this.questionAnswer = questionanswer;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getQuestionanswer() {
        return questionAnswer;
    }

    public void setQuestionanswer(String questionanswer) {
        this.questionAnswer = questionanswer;
    }

    public Integer getQuestionid() {
        return questionId;
    }

    public void setQuestionid(Integer questionid) {
        this.questionId = questionid;
    }

    public String getQuestiontype() {
        return questionType;
    }

    public void setQuestiontype(String questiontype) {
        this.questionType = questiontype;
    }

    public Date getCreatetime() {
        return createTime;
    }

    public void setCreatetime(Date createtime) {
        this.createTime = createtime;
    }

    public String getQuestiondescription() {
        return questionDescription;
    }

    public void setQuestiondescription(String questiondescription) {
        this.questionDescription = questiondescription;
    }

    @Override
    public String toString() {
        return "Questionpool{" +
                "questionid=" + questionId +
                ", questiontype='" + questionType + '\'' +
                ", createtime=" + createTime +
                ", questiondescription='" + questionDescription + '\'' +
                ", questionanswer='" + questionAnswer + '\'' +
                ", userid=" + userId +
                '}';
    }
}