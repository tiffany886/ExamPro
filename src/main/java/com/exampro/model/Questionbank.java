package com.exampro.model;

import java.io.Serializable;
import java.util.Date;

public class Questionbank implements Serializable {
    /**
     * 题库ID
     *
     * @mbg.generated
     */
    private Integer bankid;

    /**
     * 题库名称
     *
     * @mbg.generated
     */
    private String bankname;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bankid=").append(bankid);
        sb.append(", bankname=").append(bankname);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}