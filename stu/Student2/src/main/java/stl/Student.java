package stl;

public class Student {
    private String sid;
    private String sname;
    private String sage;
    private String ssex;
    private int sl;
    private int zcj;
    private String cid;
    private String cname;
    private String tid;
    private String tname;
    private String score;


    public Student() {
    }

    public Student(String sid, String sname, String sage, String ssex, int sl, int zcj) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sl = sl;
        this.zcj = zcj;
    }
    public Student(String sid, String sname, String sage, String ssex, String cid, String cname, String tid, String tname, String score) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.tname = tname;
        this.score = score;
    }

    public Student(String sid, String sname, String sage, String ssex, int sl, int zcj, String cid, String cname,
                   String tid, String tname, String score) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sl = sl;
        this.zcj = zcj;
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.tname = tname;
        this.score = score;
    }

    public Student(String sid, String sname, String sage, String ssex) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getZcj() {
        return zcj;
    }

    public void setZcj(int zcj) {
        this.zcj = zcj;
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
