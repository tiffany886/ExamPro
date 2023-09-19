package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Gradingmanagement implements Serializable {
    /**
     * 评卷ID
     *
     * @mbg.generated
     */
    private Integer gradingid;

    /**
     * 试卷ID
     *
     * @mbg.generated
     */
    private Integer paperid;

    /**
     * 考生ID
     *
     * @mbg.generated
     */
    private Integer examineeid;

    /**
     * 创建人ID
     *
     * @mbg.generated
     */
    private Integer graderid;

    /**
     * 开始评卷时间
     *
     * @mbg.generated
     */
    private Date starttime;

    /**
     * 结束评卷时间
     *
     * @mbg.generated
     */
    private Date endtime;

    /**
     * 客观题分数
     *
     * @mbg.generated
     */
    private Integer objectivescore;

    /**
     * 主观题分数
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

    private static final long serialVersionUID = 1L;

    public Integer getGradingid() {
        return gradingid;
    }

    public void setGradingid(Integer gradingid) {
        this.gradingid = gradingid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getExamineeid() {
        return examineeid;
    }

    public void setExamineeid(Integer examineeid) {
        this.examineeid = examineeid;
    }

    public Integer getGraderid() {
        return graderid;
    }

    public void setGraderid(Integer graderid) {
        this.graderid = graderid;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gradingid=").append(gradingid);
        sb.append(", paperid=").append(paperid);
        sb.append(", examineeid=").append(examineeid);
        sb.append(", graderid=").append(graderid);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", objectivescore=").append(objectivescore);
        sb.append(", subjectivescore=").append(subjectivescore);
        sb.append(", totalscore=").append(totalscore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}