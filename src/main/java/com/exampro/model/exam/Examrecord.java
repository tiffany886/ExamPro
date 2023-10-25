package com.exampro.model.exam;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;

public class Examrecord implements Serializable {
    /**
     * 记录ID
     */
    private Integer recordId;
    /**
     * 试卷id
     */
    private Integer paperId;

    /**
     * 试卷id
     */
    private Integer questionId;

    /**
     * 学生答案
     */
    private String studentAnswer;

    /**
     * 获得分数
     */
    private Integer score;

    /**
     * 答案总分
     */
    private Integer totalScore;

    /**
     * 考试ID
     */
    private Integer examId;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Examrecord(Integer recordId, Integer paperId, Integer questionId, String studentAnswer, Integer score, Integer totalScore, Integer examId, Integer userId) {
        this.recordId = recordId;
        this.paperId = paperId;
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
        this.score = score;
        this.totalScore = totalScore;
        this.examId = examId;
        this.userId = userId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
    public Examrecord(){}
    public Examrecord(Integer recordId, Integer paperId, Integer questionId, String studentAnswer, Integer score, Integer totalScore, Integer examId) {
        this.recordId = recordId;
        this.paperId = paperId;
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
        this.score = score;
        this.totalScore = totalScore;
        this.examId = examId;
    }
}