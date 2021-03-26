package com.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName: demo_xy
 * @className: Client
 * @description:
 * @author: xy
 * @time: 2021/3/26 16:19
 */
public class Consumer implements Serializable {

    private Long id;
    private String name;
    private Integer sex;
    private Date birthdate;
    private String tel;
    private String job;
    private String note;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", tel='" + tel + '\'' +
                ", job='" + job + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
