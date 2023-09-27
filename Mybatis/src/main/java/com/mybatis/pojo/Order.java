package com.mybatis.pojo;

import java.util.Date;
import com.mybatis.pojo.Consumer;

public class Order {
    private  int  oid;
    private  String  oname;
    private  int  cid;
    private Date createtime;
    private Consumer consumer;

    public Order() {
    }

    public Order(int oid, String oname, int cid, Date createtime) {
        this.oid = oid;
        this.oname = oname;
        this.cid = cid;
        this.createtime = createtime;
    }

    public Order(int oid, String oname, int cid, Date createtime, Consumer consumer) {
        this.oid = oid;
        this.oname = oname;
        this.cid = cid;
        this.createtime = createtime;
        this.consumer = consumer;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", cid=" + cid +
                ", createtime=" + createtime +
                '}';
    }
}
