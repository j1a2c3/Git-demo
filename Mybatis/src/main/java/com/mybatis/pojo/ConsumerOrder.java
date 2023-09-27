package com.mybatis.pojo;

import java.util.Date;

public class ConsumerOrder extends Consumer {
    private  int  oid;
    private  String  oname;
    private  int  cid;
    private Date createtime;

    public ConsumerOrder(int oid, String oname, int cid, Date createtime) {
        this.oid = oid;
        this.oname = oname;
        this.cid = cid;
        this.createtime = createtime;
    }

    public ConsumerOrder(int cid, String cname, String csex, int oid, String oname,  Date createtime) {
        super(cid, cname, csex);
        this.oid = oid;
        this.oname = oname;
        this.createtime = createtime;
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

    @Override
    public int getCid() {
        return cid;
    }

    @Override
    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ConsumerOrder{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", cid=" + cid +
                ", createtime=" + createtime +
                "} " + super.toString();
    }
}
