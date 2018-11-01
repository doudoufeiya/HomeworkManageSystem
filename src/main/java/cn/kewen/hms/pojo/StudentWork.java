package cn.kewen.hms.pojo;

import java.util.Date;

/**
 * @author shen
 * @version 1.0.0
 * @since 2018/10/31
 */
public class StudentWork {

    /**
     * 作业id
     */
    private Integer tw_id;
    /**
     * 作业名
     */
    private String tw_name;

    /**
     * 教师Id
     */
    private Integer tw_tid;

    /**
     * 教师名
     */
    private String t_name;


    /**
     * 作业新增时间
     */
    private Date tw_addTime;

    /**
     * 截止日期
     */
    private Date tw_deadLine;

    /**
     * 作业要求文件名
     */
    private String tw_file_name;

    /**
     * 作业要求文件路径
     */
    private String tw_file_path;

    /**
     * 班级ID
     */
    private String tw_cid;

    /**
     * 课程ID
     */
    private Integer l_id;

    /**
     * 课程名称
     */
    private String l_name;

    /**
     * 学生提交的作业id
     */
    private Integer sw_id;

    /**
     * 学生提交的作业名
     */
    private String sw_name;

    /**
     * 学生ID
     */
    private Integer sw_sid;

    /**
     * 老师作业ID
     */
    private Integer sw_wid;

    /**
     * 学生提交的作业文件名
     */
    private String sw_file_name;

    /**
     * 学生提交的作业路径
     */
    private String sw_file_path;

    /**
     *  分数
     */
    private Integer sw_gradle;

    /**
     * 评阅意见
     */
    private String sw_remark;

    /**
     * 批改时间
     */
    private Date correctTime;

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getTw_id() {
        return tw_id;
    }

    public void setTw_id(Integer tw_id) {
        this.tw_id = tw_id;
    }

    public String getTw_name() {
        return tw_name;
    }

    public void setTw_name(String tw_name) {
        this.tw_name = tw_name;
    }

    public Integer getTw_tid() {
        return tw_tid;
    }

    public void setTw_tid(Integer tw_tid) {
        this.tw_tid = tw_tid;
    }

    public Date getTw_addTime() {
        return tw_addTime;
    }

    public void setTw_addTime(Date tw_addTime) {
        this.tw_addTime = tw_addTime;
    }

    public Date getTw_deadLine() {
        return tw_deadLine;
    }

    public void setTw_deadLine(Date tw_deadLine) {
        this.tw_deadLine = tw_deadLine;
    }

    public String getTw_file_name() {
        return tw_file_name;
    }

    public void setTw_file_name(String tw_file_name) {
        this.tw_file_name = tw_file_name;
    }

    public String getTw_file_path() {
        return tw_file_path;
    }

    public void setTw_file_path(String tw_file_path) {
        this.tw_file_path = tw_file_path;
    }

    public String getTw_cid() {
        return tw_cid;
    }

    public void setTw_cid(String tw_cid) {
        this.tw_cid = tw_cid;
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
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

    public Integer getSw_sid() {
        return sw_sid;
    }

    public void setSw_sid(Integer sw_sid) {
        this.sw_sid = sw_sid;
    }

    public Integer getSw_wid() {
        return sw_wid;
    }

    public void setSw_wid(Integer sw_wid) {
        this.sw_wid = sw_wid;
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

    public Integer getSw_gradle() {
        return sw_gradle;
    }

    public void setSw_gradle(Integer sw_gradle) {
        this.sw_gradle = sw_gradle;
    }

    public String getSw_remark() {
        return sw_remark;
    }

    public void setSw_remark(String sw_remark) {
        this.sw_remark = sw_remark;
    }

    public Date getCorrectTime() {
        return correctTime;
    }

    public void setCorrectTime(Date correctTime) {
        this.correctTime = correctTime;
    }


    @Override
    public String toString() {
        return "StudentWork{" +
                "tw_id=" + tw_id +
                ", tw_name='" + tw_name + '\'' +
                ", tw_tid=" + tw_tid +
                ", tw_addTime=" + tw_addTime +
                ", tw_deadLine=" + tw_deadLine +
                ", tw_file_name='" + tw_file_name + '\'' +
                ", tw_file_path='" + tw_file_path + '\'' +
                ", tw_cid='" + tw_cid + '\'' +
                ", l_id=" + l_id +
                ", l_name='" + l_name + '\'' +
                ", sw_id=" + sw_id +
                ", sw_name='" + sw_name + '\'' +
                ", sw_sid=" + sw_sid +
                ", sw_wid=" + sw_wid +
                ", sw_file_name='" + sw_file_name + '\'' +
                ", sw_file_path='" + sw_file_path + '\'' +
                ", sw_gradle=" + sw_gradle +
                ", sw_remark='" + sw_remark + '\'' +
                ", correctTime=" + correctTime +
                '}';
    }
}
