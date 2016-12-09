package org.zdlearn.java.simple.nettyrpc.pojo;

/**
 * Created by wyzhangdong on 2016/12/9.
 */
public class UserObject {

    private String name;
    private int age;

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
