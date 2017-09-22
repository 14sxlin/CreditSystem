package bean;

/**
 * Created by MirQ on 17/9/22.
 */
public class Publish_Course {
    private int id;         //开课编号
    private int course_id;
    private int tea_id;
    private int exp_num;
    private int real_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public int getExp_num() {
        return exp_num;
    }

    public void setExp_num(int exp_num) {
        this.exp_num = exp_num;
    }

    public int getReal_num() {
        return real_num;
    }

    public void setReal_num(int real_num) {
        this.real_num = real_num;
    }
}

