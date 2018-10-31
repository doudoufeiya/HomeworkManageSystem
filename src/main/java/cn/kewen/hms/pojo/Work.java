package cn.kewen.hms.pojo;

import java.util.Date;

/**
 * 作业实体
 */
public class Work {
    private Integer tw_id;
    private String tw_name;
    private Integer tw_tid;
    private Date tw_addTime;
    private Date tw_deadLine;
    private String tw_file_name;
    private String tw_file_path;

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
}
