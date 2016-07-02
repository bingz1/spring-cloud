package me.wantgo.member.entity;

/**
 * Created by zxb on 7/2/16.
 */
public class FeedBack {
    private String name;
    private int age;

    public FeedBack() {

    }

    public FeedBack(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
