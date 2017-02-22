package liophan.mvvmdemo.model;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 22, 2017
 */

public class User {
    private String name;
    private String school;
    private int age;

    public User(String name, String school, int age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int doubleAge() {
        return age + age;
    }
}
