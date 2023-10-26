package com.exampro.model.exam;

import java.io.Serializable;

public class Examregistration implements Serializable {
    /**
     * 报名ID
     *
     */
    private Integer registrationid;

    /**
     * 考试ID
     */
    private Integer examid;

    /**
     * 用户ID
     */
    private Integer userid;

    private static final long serialVersionUID = 1L;

    public Integer getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(Integer registrationid) {
        this.registrationid = registrationid;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registrationid=").append(registrationid);
        sb.append(", examid=").append(examid);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}