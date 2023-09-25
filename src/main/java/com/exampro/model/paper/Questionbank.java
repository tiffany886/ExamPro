package com.exampro.model.paper;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 题库表
 */
public class Questionbank implements Serializable {
    /**
     * 题库ID
     *
     */
    private Integer bankId;

    /**
     * 题库名称
     *
     */
    private String bankName;

    /**
     * 创建时间
     *
     */
    private Date createTime;
    /**
     *
     * 创建用户
     */
    private Integer userId;

    public Questionbank(Integer bankId, String bankName, Date createTime, Integer userId) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.createTime = createTime;
        this.userId = userId;
    }

    public Questionbank(String bankName, Integer userId) {
        this.bankName = bankName;
        this.userId = userId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Questionbank{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                '}';
    }
}