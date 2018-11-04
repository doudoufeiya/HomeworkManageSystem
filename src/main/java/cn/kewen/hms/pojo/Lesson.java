package cn.kewen.hms.pojo;

import java.util.List;

public class Lesson {
    private Integer l_id;
    private String l_name;
    private String t_name;
    private List<Integer> students;
    private Integer t_id;


    public Lesson() {
        super();
    }

    public Lesson(int l_id, String l_name) {
        super();
        this.l_id = l_id;
        this.l_name = l_name;
    }

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

    public List<Integer> getStudents() {
        return students;
    }

    public void setStudents(List<Integer> students) {
        this.students = students;
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
}
