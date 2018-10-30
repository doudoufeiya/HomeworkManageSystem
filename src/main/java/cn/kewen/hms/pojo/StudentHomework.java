package cn.kewen.hms.pojo;

import java.util.Date;

public class StudentHomework {
	private int sw_id;
	private String sw_name;
	private int sw_sid;
    private int sw_tid;
    private String sw_file_name;
    private String sw_file_path;
    private int sw_grade;
    private String sw_remark;
    private Date sw_correctTime;
	public StudentHomework() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentHomework(int sw_id, String sw_name, int sw_sid, int sw_tid,
			String sw_file_name, String sw_file_path, int sw_grade,
			String sw_remark, Date sw_correctTime) {
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
	}

	public int getSw_id() {
		return sw_id;
	}
	public void setSw_id(int sw_id) {
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
	public int getSw_grade() {
		return sw_grade;
	}
	public void setSw_grade(int sw_grade) {
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
}
