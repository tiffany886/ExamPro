package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Papermanagement implements Serializable {
    /**
     * 试卷ID
     *
     * @mbg.generated
     */
    private Integer paperid;

    /**
     * 试卷名称
     *
     * @mbg.generated
     */
    private String papername;

    /**
     * 客观题分数
     *
     * @mbg.generated
     */
    private Integer objectivescore;

    /**
     * 总分
     *
     * @mbg.generated
     */
    private Integer totalscore;

    /**
     * 主观题分数
     *
     * @mbg.generated
     */
    private Integer subjectivescore;

    /**
     * 考试开始时间
     *
     * @mbg.generated
     */
    private Date starttime;

    /**
     * 考试结束时间
     *
     * @mbg.generated
     */
    private Date endtime;

    /**
     * 考试人数
     *
     * @mbg.generated
     */
    private Integer numberofexaminees;

    /**
     * 创建人ID
     *
     * @mbg.generated
     */
    private Integer createdby;

    private static final long serialVersionUID = 1L;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public Integer getObjectivescore() {
        return objectivescore;
    }

    public void setObjectivescore(Integer objectivescore) {
        this.objectivescore = objectivescore;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getSubjectivescore() {
        return subjectivescore;
    }

    public void setSubjectivescore(Integer subjectivescore) {
        this.subjectivescore = subjectivescore;
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

    public Integer getNumberofexaminees() {
        return numberofexaminees;
    }

    public void setNumberofexaminees(Integer numberofexaminees) {
        this.numberofexaminees = numberofexaminees;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paperid=").append(paperid);
        sb.append(", papername=").append(papername);
        sb.append(", objectivescore=").append(objectivescore);
        sb.append(", totalscore=").append(totalscore);
        sb.append(", subjectivescore=").append(subjectivescore);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", numberofexaminees=").append(numberofexaminees);
        sb.append(", createdby=").append(createdby);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}