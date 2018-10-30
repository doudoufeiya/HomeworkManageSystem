package cn.kewen.hms.pojo;

public class Teacher {
    private int t_id;
    private String t_number;
    private String t_pwd;
    private String t_name;
    private String t_sex;
    private String t_phone;
    private String t_photo;
    private int t_lesson;

    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Teacher(int t_id, String t_number, String t_pwd, String t_name,
                   String t_sex, String t_phone, String t_photo, int t_lesson) {
        super();
        this.t_id = t_id;
        this.t_number = t_number;
        this.t_pwd = t_pwd;
        this.t_name = t_name;
        this.t_sex = t_sex;
        this.t_phone = t_phone;
        this.t_photo = t_photo;
        this.t_lesson = t_lesson;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
    }

    public String getT_pwd() {
        return t_pwd;
    }

    public void setT_pwd(String t_pwd) {
        this.t_pwd = t_pwd;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_photo() {
        return t_photo;
    }

    public void setT_photo(String t_photo) {
        this.t_photo = t_photo;
    }

    public int getT_lesson() {
        return t_lesson;
    }

    public void setT_lesson(int t_lesson) {
        this.t_lesson = t_lesson;
    }
}
