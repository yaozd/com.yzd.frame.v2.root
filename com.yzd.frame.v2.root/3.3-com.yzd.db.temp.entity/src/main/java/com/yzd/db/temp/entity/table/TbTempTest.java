package com.yzd.db.temp.entity.table;

import java.util.Date;

public class TbTempTest {
    private Long id;

    private String name;

    private String password;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer gmtIsDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getGmtIsDeleted() {
        return gmtIsDeleted;
    }

    public void setGmtIsDeleted(Integer gmtIsDeleted) {
        this.gmtIsDeleted = gmtIsDeleted;
    }
}