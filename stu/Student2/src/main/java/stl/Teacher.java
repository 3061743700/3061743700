package stl;

public class Teacher {
    private int tid;
    private String tname;

    public Teacher(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher() {

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
