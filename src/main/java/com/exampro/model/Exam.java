package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Exam implements Serializable {
    /**
     * 考试ID
     *
     * @mbg.generated
     */
    private Integer examid;

    /**
     * 考试名称
     *
     * @mbg.generated
     */
    private String examname;

    /**
     * 考试描述
     *
     * @mbg.generated
     */
    private String examdescription;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Date starttime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Date endtime;

    private static final long serialVersionUID = 1L;

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getExamdescription() {
        return examdescription;
    }

    public void setExamdescription(String examdescription) {
        this.examdescription = examdescription;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examid=").append(examid);
        sb.append(", examname=").append(examname);
        sb.append(", examdescription=").append(examdescription);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}