package com.mybatis.pojo;

import java.util.List;

public class Consumer {
    private  int  cid;
    private  String  cname;
    private String  csex;
    private List<Order> order;

    public Consumer() {
    }

    public Consumer(int cid, String cname, String csex) {
        this.cid = cid;
        this.cname = cname;
        this.csex = csex;
    }

    public Consumer(int cid, String cname, String csex, List<Order> order) {
        this.cid = cid;
        this.cname = cname;
        this.csex = csex;
        this.order = order;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", order=" + order +
                '}';
    }
}
