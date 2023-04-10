package stl;

public class Course {
    private String cid;
    private String cname;
    private int tid;

    public Course() {
    }

    public Course(String cid, String cname, int tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", tid=" + tid +
                '}';
    }
}
