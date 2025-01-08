package com.test.spring6.iocxml;

import java.util.ArrayList;

public class ClassWithArray {

    private String name;
    private BasicClass teacher;
    private ArrayList<String> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicClass getTeacher() {
        return teacher;
    }

    public void setTeacher(BasicClass teacher) {
        this.teacher = teacher;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", hobbies=" + hobbies +
                '}';
    }
}
