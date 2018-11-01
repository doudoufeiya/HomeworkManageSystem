package cn.kewen.hms.pojo;

import java.util.Date;

/**
 * @author shen
 * @version 1.0.0
 * @since 2018/11/1
 */
public class Question {
    /**
     * 问题ID
     */
    private Integer question_id;
    /**
     * 教师ID
     */
    private Integer t_id;
    /**
     * 学生id
     */
    private Integer s_id;
    /**
     * type,0是学生，1是教师
     */
    private Integer type;
    /**
     * 发送时间
     */
    private Date msg_date;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getMsg_date() {
        return msg_date;
    }

    public void setMsg_date(Date msg_date) {
        this.msg_date = msg_date;
    }
}
