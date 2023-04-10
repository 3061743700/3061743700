package stl;

import java.util.List;

public class Page {
    private int pageNum;   //当前页
    private int pageSize;   //每页条数
    private int pre;        //上一页
    private int next;       //下一页
    private int pe;         //总页码
    private int total;      //总条数
    private int start;      //每一页开始索引

    private List<Student> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Page(int pageNum, int pageSize, int total){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.start=(pageNum-1)*pageSize;

        this.pre=pageNum-1;
        if(pre<1){
            this.pre=1;
        }

        this.pe=(total-1)/pageSize+1;
        this.next=pageNum+1;
        if(next>pe) {
            this.next=pe;
        }
    }
}
