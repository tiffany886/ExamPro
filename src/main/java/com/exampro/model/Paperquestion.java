package com.exampro.model;

import java.io.Serializable;

public class Paperquestion implements Serializable {
    /**
     * 关联ID
     *
     * @mbg.generated
     */
    private Integer linkid;

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

    private static final long serialVersionUID = 1L;

    public Integer getLinkid() {
        return linkid;
    }

    public void setLinkid(Integer linkid) {
        this.linkid = linkid;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linkid=").append(linkid);
        sb.append(", paperid=").append(paperid);
        sb.append(", questionid=").append(questionid);
        sb.append(", questiontype=").append(questiontype);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}