package com.example.domain;

import java.util.Date;

/**
 * @projectName: demo_xy
 * @className: queryVo
 * @description:
 * @author: xy
 * @time: 2021/3/26 19:32
 */

/**
 * 作为搜索的包装类
 */
public class QueryVo {

    private String name;
    private Integer sex;
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "queryVo{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                '}';
    }
}
