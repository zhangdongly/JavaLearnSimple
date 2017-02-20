package org.zdlearn.java.simple.nettyrpc.pojo;

import java.io.Serializable;

/**
 * Created by zhangdong147896325@163.com on 2016/12/9.
 */
public class UserObject implements Serializable{

    private String name;
    private int age;

    public UserObject(){

    }

    public UserObject(int age,String name) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
