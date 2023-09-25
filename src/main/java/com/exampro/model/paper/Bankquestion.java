package com.exampro.model.paper;

import java.io.Serializable;

/**
 * 题目题库管理表
 */
public class Bankquestion implements Serializable {
    /**
     * 关联ID
     *
     */
    private Integer linkid;

    /**
     * 题库ID
     *
     */
    private Integer bankid;

    /**
     * 题目ID
     *
     */
    private Integer questionid;

    private static final long serialVersionUID = 1L;

    public Integer getLinkid() {
        return linkid;
    }

    public void setLinkid(Integer linkid) {
        this.linkid = linkid;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linkid=").append(linkid);
        sb.append(", bankid=").append(bankid);
        sb.append(", questionid=").append(questionid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}