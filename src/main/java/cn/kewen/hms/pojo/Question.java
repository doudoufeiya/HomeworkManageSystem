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
     * 学生id
     */
    private Integer s_id;

    /**
     * 姓名
     */
    private String s_name;

    /**
     * 发送时间
     */
    private Date send_date;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    private Integer t_id;
    private String t_name;

    private Date answer_date;

    private String answer_content;

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Date getAnswer_date() {
        return answer_date;
    }

    public void setAnswer_date(Date answer_date) {
        this.answer_date = answer_date;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
