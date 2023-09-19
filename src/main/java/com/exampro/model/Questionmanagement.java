package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Questionmanagement implements Serializable {
    /**
     * 试题ID
     *
     * @mbg.generated
     */
    private Integer questionid;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 是否归类到题库
     *
     * @mbg.generated
     */
    private Boolean isinbank;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * 试题内容
     *
     * @mbg.generated
     */
    private String questioncontent;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getIsinbank() {
        return isinbank;
    }

    public void setIsinbank(Boolean isinbank) {
        this.isinbank = isinbank;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionid=").append(questionid);
        sb.append(", userid=").append(userid);
        sb.append(", isinbank=").append(isinbank);
        sb.append(", createtime=").append(createtime);
        sb.append(", questioncontent=").append(questioncontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}