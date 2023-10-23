package com.exampro.model.paper;

/**
 * @Auther pluto
 * @Date 2023/10/23
 */
public class paperQuesItem {
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
     * 问题答案
     * @return
     */
    private String questionAnswer;

    /**
     * 问题分数
     * @return
     */
    private Integer questionScore;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Integer getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Integer questionScore) {
        this.questionScore = questionScore;
    }

    @Override
    public String toString() {
        return "paperQuesItem{" +
                "questionType='" + questionType + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionScore=" + questionScore +
                '}';
    }
}
