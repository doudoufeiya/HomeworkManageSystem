package cn.kewen.hms.pojo;

import java.util.Date;

/**
 * 教学资料
 */
public class Resource {
    private Integer r_id;
    private String r_name;
    private String r_file_name;
    private String r_file_path;
    private Date r_time;
    private String r_message;
    private Integer r_tid;
    private String r_tname;

    public String getR_tname() {
        return r_tname;
    }

    public void setR_tname(String r_tname) {
        this.r_tname = r_tname;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_file_name() {
        return r_file_name;
    }

    public void setR_file_name(String r_file_name) {
        this.r_file_name = r_file_name;
    }

    public String getR_file_path() {
        return r_file_path;
    }

    public void setR_file_path(String r_file_path) {
        this.r_file_path = r_file_path;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public String getR_message() {
        return r_message;
    }

    public void setR_message(String r_message) {
        this.r_message = r_message;
    }

    public Integer getR_tid() {
        return r_tid;
    }

    public void setR_tid(Integer r_tid) {
        this.r_tid = r_tid;
    }
}
