package com.mybatis.pojo;

import java.util.List;

public class QueryVo {
    private int  parm1;
    private int  parm2;
    private List<Integer> uids;

    public QueryVo(int parm1, int parm2, List<Integer> uids) {
        this.parm1 = parm1;
        this.parm2 = parm2;
        this.uids = uids;
    }

    public QueryVo() {
    }

    public int getParm1() {
        return parm1;
    }

    public int getParm2() {
        return parm2;
    }

    public List<Integer> getUids() {
        return uids;
    }

    public void setParm1(int parm1) {
        this.parm1 = parm1;
    }

    public void setParm2(int parm2) {
        this.parm2 = parm2;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }
}
