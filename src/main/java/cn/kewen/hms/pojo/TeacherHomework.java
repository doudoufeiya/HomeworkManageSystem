package cn.kewen.hms.pojo;

import java.util.Date;

public class TeacherHomework {
    private int tw_id;
    private String tw_name;
    private int tw_tid;
    private Date tw_addTime;
    private Date tw_deadLine;
    private String tw_file_name;
    private String tw_file_path;

    public TeacherHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TeacherHomework(int tw_id, String tw_name, int tw_tid,
                           Date tw_addTime, Date tw_deadLine, String tw_file_name,
                           String tw_file_path) {
        super();
        this.tw_id = tw_id;
        this.tw_name = tw_name;
        this.tw_tid = tw_tid;
        this.tw_addTime = tw_addTime;
        this.tw_deadLine = tw_deadLine;
        this.tw_file_name = tw_file_name;
        this.tw_file_path = tw_file_path;
    }

    public int getTw_id() {
        return tw_id;
    }

    public void setTw_id(int tw_id) {
        this.tw_id = tw_id;
    }

    public String getTw_name() {
        return tw_name;
    }

    public void setTw_name(String tw_name) {
        this.tw_name = tw_name;
    }

    public int getTw_tid() {
        return tw_tid;
    }

    public void setTw_tid(int tw_tid) {
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
