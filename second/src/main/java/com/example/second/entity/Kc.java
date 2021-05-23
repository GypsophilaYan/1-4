package com.example.second.entity;

import java.io.Serializable;

/**
 * kc
 * @author 
 */
public class Kc implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 课程编号
     */
    private String kcnumber;

    /**
     * 课程名称
     */
    private String kcname;

    /**
     * 课程类型
     */
    private String kctype;

    /**
     * 开课学院
     */
    private String kccollege;

    /**
     * 开课教室
     */
    private String kcroom;

    /**
     * 课时
     */
    private String kctimes;

    /**
     * 单节时长
     */
    private String kcduration;

    /**
     * 课程介绍
     */
    private String kcintroduce;

    /**
     * 课程介绍
     */
    private String isdelete;

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKcnumber() {
        return kcnumber;
    }

    public void setKcnumber(String kcnumber) {
        this.kcnumber = kcnumber;
    }

    public String getKcname() {
        return kcname;
    }

    public void setKcname(String kcname) {
        this.kcname = kcname;
    }

    public String getKctype() {
        return kctype;
    }

    public void setKctype(String kctype) {
        this.kctype = kctype;
    }

    public String getKccollege() {
        return kccollege;
    }

    public void setKccollege(String kccollege) {
        this.kccollege = kccollege;
    }

    public String getKcroom() {
        return kcroom;
    }

    public void setKcroom(String kcroom) {
        this.kcroom = kcroom;
    }

    public String getKctimes() {
        return kctimes;
    }

    public void setKctimes(String kctimes) {
        this.kctimes = kctimes;
    }

    public String getKcduration() {
        return kcduration;
    }

    public void setKcduration(String kcduration) {
        this.kcduration = kcduration;
    }

    public String getKcintroduce() {
        return kcintroduce;
    }

    public void setKcintroduce(String kcintroduce) {
        this.kcintroduce = kcintroduce;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Kc other = (Kc) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getKcnumber() == null ? other.getKcnumber() == null : this.getKcnumber().equals(other.getKcnumber()))
            && (this.getKcname() == null ? other.getKcname() == null : this.getKcname().equals(other.getKcname()))
            && (this.getKctype() == null ? other.getKctype() == null : this.getKctype().equals(other.getKctype()))
            && (this.getKccollege() == null ? other.getKccollege() == null : this.getKccollege().equals(other.getKccollege()))
            && (this.getKcroom() == null ? other.getKcroom() == null : this.getKcroom().equals(other.getKcroom()))
            && (this.getKctimes() == null ? other.getKctimes() == null : this.getKctimes().equals(other.getKctimes()))
            && (this.getKcduration() == null ? other.getKcduration() == null : this.getKcduration().equals(other.getKcduration()))
            && (this.getKcintroduce() == null ? other.getKcintroduce() == null : this.getKcintroduce().equals(other.getKcintroduce()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getKcnumber() == null) ? 0 : getKcnumber().hashCode());
        result = prime * result + ((getKcname() == null) ? 0 : getKcname().hashCode());
        result = prime * result + ((getKctype() == null) ? 0 : getKctype().hashCode());
        result = prime * result + ((getKccollege() == null) ? 0 : getKccollege().hashCode());
        result = prime * result + ((getKcroom() == null) ? 0 : getKcroom().hashCode());
        result = prime * result + ((getKctimes() == null) ? 0 : getKctimes().hashCode());
        result = prime * result + ((getKcduration() == null) ? 0 : getKcduration().hashCode());
        result = prime * result + ((getKcintroduce() == null) ? 0 : getKcintroduce().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", kcnumber=").append(kcnumber);
        sb.append(", kcname=").append(kcname);
        sb.append(", kctype=").append(kctype);
        sb.append(", kccollege=").append(kccollege);
        sb.append(", kcroom=").append(kcroom);
        sb.append(", kctimes=").append(kctimes);
        sb.append(", kcduration=").append(kcduration);
        sb.append(", kcintroduce=").append(kcintroduce);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}