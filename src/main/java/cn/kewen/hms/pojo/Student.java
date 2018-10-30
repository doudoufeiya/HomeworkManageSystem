package cn.kewen.hms.pojo;

public class Student {
    private int s_id;
    private int s_number;
    private String s_pwd;
    private String s_name;
    private String s_sex;
    private String s_major;
    private String s_phone;
    private int s_points;

    public int getS_points() {
        return s_points;
    }

    public void setS_points(int s_points) {
        this.s_points = s_points;
    }

    private int s_cid;

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_number() {
        return s_number;
    }

    public void setS_number(int s_number) {
        this.s_number = s_number;
    }

    public String getS_pwd() {
        return s_pwd;
    }

    public void setS_pwd(String s_pwd) {
        this.s_pwd = s_pwd;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        this.s_major = s_major;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public int getS_cid() {
        return s_cid;
    }

    public void setS_cid(int s_cid) {
        this.s_cid = s_cid;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(int s_id, int s_number, String s_pwd, String s_name,
                   String s_sex, String s_major, String s_phone, int points, int s_cid) {
        super();
        this.s_id = s_id;
        this.s_number = s_number;
        this.s_pwd = s_pwd;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.s_major = s_major;
        this.s_phone = s_phone;
        this.s_points = points;
        this.s_cid = s_cid;
    }
}
