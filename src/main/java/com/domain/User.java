package com.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String name;
    private String pwd;
    private String sex;
    private String  lhl;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
