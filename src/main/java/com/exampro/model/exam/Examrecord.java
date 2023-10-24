package com.exampro.model.exam;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;

public class Examrecord implements Serializable {
    /**
     * 记录ID
     */
    private Integer recordid;

    /**
     * 考试ID
     */
    private Integer examid;

    /**
     * 试卷id
     */
    private Integer paperid;

    /**
     * 试卷id
     */
    private Integer questionid;

    /**
     * 学生答案
     */
    private String studentanswer;

    /**
     * 获得分数
     */
    private Integer score;

    /**
     * 答案总分
     */
    private Integer totalscore;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getStudentanswer() {
        return studentanswer;
    }

    public void setStudentanswer(String studentanswer) {
        this.studentanswer = studentanswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    @Override
    public String toString() {
        return "Examrecord{" +
                "recordid=" + recordid +
                ", examid=" + examid +
                ", paperid=" + paperid +
                ", questionid=" + questionid +
                ", studentanswer='" + studentanswer + '\'' +
                ", score='" + score + '\'' +
                ", totalscore='" + totalscore + '\'' +
                '}';
    }
}