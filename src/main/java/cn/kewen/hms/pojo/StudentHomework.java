package cn.kewen.hms.pojo;

import java.util.Date;

public class StudentHomework {
    private Integer sw_id;
    private String sw_name;
    private int sw_sid;
    private int sw_tid;
    private String sw_file_name;
    private String sw_file_path;
    private Integer sw_grade;
    private String sw_remark;
    private Date sw_addTime;
    private Date sw_correctTime;
    private String s_number;

    public StudentHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StudentHomework(Integer sw_id, String sw_name, int sw_sid, int sw_tid,
                           String sw_file_name, String sw_file_path, Integer sw_grade,
                           String sw_remark, Date sw_correctTime, Date sw_addTime, String s_number) {
        super();
        this.sw_id = sw_id;
        this.sw_name = sw_name;
        this.sw_sid = sw_sid;
        this.sw_tid = sw_tid;
        this.sw_file_name = sw_file_name;
        this.sw_file_path = sw_file_path;
        this.sw_grade = sw_grade;
        this.sw_remark = sw_remark;
        this.sw_correctTime = sw_correctTime;
        this.sw_addTime = sw_addTime;
        this.s_number = s_number;
    }

    public Integer getSw_id() {
        return sw_id;
    }

    public void setSw_id(Integer sw_id) {
        this.sw_id = sw_id;
    }

    public String getSw_name() {
        return sw_name;
    }

    public void setSw_name(String sw_name) {
        this.sw_name = sw_name;
    }

    public int getSw_sid() {
        return sw_sid;
    }

    public void setSw_sid(int sw_sid) {
        this.sw_sid = sw_sid;
    }

    public int getSw_tid() {
        return sw_tid;
    }

    public void setSw_tid(int sw_tid) {
        this.sw_tid = sw_tid;
    }

    public String getSw_file_name() {
        return sw_file_name;
    }

    public void setSw_file_name(String sw_file_name) {
        this.sw_file_name = sw_file_name;
    }

    public String getSw_file_path() {
        return sw_file_path;
    }

    public void setSw_file_path(String sw_file_path) {
        this.sw_file_path = sw_file_path;
    }

    public Integer getSw_grade() {
        return sw_grade;
    }

    public void setSw_grade(Integer sw_grade) {
        this.sw_grade = sw_grade;
    }

    public String getSw_remark() {
        return sw_remark;
    }

    public void setSw_remark(String sw_remark) {
        this.sw_remark = sw_remark;
    }

    public Date getSw_correctTime() {
        return sw_correctTime;
    }

    public void setSw_correctTime(Date sw_correctTime) {
        this.sw_correctTime = sw_correctTime;
    }

    public Date getSw_addTime() {
        return sw_addTime;
    }

    public void setSw_addTime(Date sw_addTime) {
        this.sw_addTime = sw_addTime;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }
}

