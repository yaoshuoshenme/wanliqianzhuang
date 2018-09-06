package com.qzwl.domain;

import java.util.Date;

public class UserRec {
    private Integer id;

    private Integer recid;

    private Integer berecid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    public Integer getBerecid() {
        return berecid;
    }

    public void setBerecid(Integer berecid) {
        this.berecid = berecid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}