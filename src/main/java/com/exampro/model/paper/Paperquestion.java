package com.exampro.model.paper;

import java.io.Serializable;

public class Paperquestion implements Serializable {

    /**
     * 试卷ID
     *
     * @mbg.generated
     */
    private Integer paperid;

    /**
     * 题目ID
     *
     * @mbg.generated
     */
    private Integer questionid;

    /**
     * 题目类型
     *
     * @mbg.generated
     */
    private String questiontype;

    /**
     * 分数
     *
     * @mbg.generated
     */
    private Integer score;

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

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Paperquestion{" +
                "paperid=" + paperid +
                ", questionid=" + questionid +
                ", questiontype='" + questiontype + '\'' +
                ", score=" + score +
                '}';
    }
}