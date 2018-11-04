package cn.kewen.hms.pojo;

import java.util.List;

/**
 * 班级实体
 */
public class Class {
    private Integer c_id;
    private String c_name;
    private List<Integer> students;
    public List<Integer> getStudents() {
        return students;
    }

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    public Class() {
        super();
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
