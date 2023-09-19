package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Examrecord implements Serializable {
    /**
     * 记录ID
     *
     * @mbg.generated
     */
    private Integer recordid;

    /**
     * 考试ID
     *
     * @mbg.generated
     */
    private Integer examid;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userid;

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

    /**
     * 客观分
     *
     * @mbg.generated
     */
    private Integer objectivescore;

    /**
     * 主观分
     *
     * @mbg.generated
     */
    private Integer subjectivescore;

    /**
     * 总分
     *
     * @mbg.generated
     */
    private Integer totalscore;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getObjectivescore() {
        return objectivescore;
    }

    public void setObjectivescore(Integer objectivescore) {
        this.objectivescore = objectivescore;
    }

    public Integer getSubjectivescore() {
        return subjectivescore;
    }

    public void setSubjectivescore(Integer subjectivescore) {
        this.subjectivescore = subjectivescore;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordid=").append(recordid);
        sb.append(", examid=").append(examid);
        sb.append(", userid=").append(userid);
        sb.append(", examdescription=").append(examdescription);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", objectivescore=").append(objectivescore);
        sb.append(", subjectivescore=").append(subjectivescore);
        sb.append(", totalscore=").append(totalscore);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}