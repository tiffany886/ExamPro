package com.exampro.model;

import java.io.Serializable;

public class Questionbankassociation implements Serializable {
    /**
     * 关联ID
     *
     * @mbg.generated
     */
    private Integer associationid;

    /**
     * 试题ID
     *
     * @mbg.generated
     */
    private Integer questionid;

    /**
     * 题库ID
     *
     * @mbg.generated
     */
    private Integer bankid;

    private static final long serialVersionUID = 1L;

    public Integer getAssociationid() {
        return associationid;
    }

    public void setAssociationid(Integer associationid) {
        this.associationid = associationid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", associationid=").append(associationid);
        sb.append(", questionid=").append(questionid);
        sb.append(", bankid=").append(bankid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}