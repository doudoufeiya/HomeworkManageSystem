package cn.kewen.hms.pojo;

public class Lesson {
    private Integer l_id;
    private String l_name;


    public Lesson() {
        super();
    }

    public Lesson(int l_id, String l_name) {
        super();
        this.l_id = l_id;
        this.l_name = l_name;
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
