package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Questionpool implements Serializable {
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
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * 题目描述
     *
     * @mbg.generated
     */
    private String questiondescription;

    private static final long serialVersionUID = 1L;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getQuestiondescription() {
        return questiondescription;
    }

    public void setQuestiondescription(String questiondescription) {
        this.questiondescription = questiondescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionid=").append(questionid);
        sb.append(", questiontype=").append(questiontype);
        sb.append(", createtime=").append(createtime);
        sb.append(", questiondescription=").append(questiondescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}