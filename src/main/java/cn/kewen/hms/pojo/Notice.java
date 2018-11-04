package cn.kewen.hms.pojo;

import java.util.Date;

/**
 * @since 2018/11/2
 * @author shen
 * @version 1.0.0
 */
public class Notice {
    private Integer n_id;
    private String n_title;
    private String n_message;
    private Date n_time;

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_message() {
        return n_message;
    }

    public void setN_message(String n_message) {
        this.n_message = n_message;
    }

    public Date getN_time() {
        return n_time;
    }

    public void setN_time(Date n_time) {
        this.n_time = n_time;
    }
}
