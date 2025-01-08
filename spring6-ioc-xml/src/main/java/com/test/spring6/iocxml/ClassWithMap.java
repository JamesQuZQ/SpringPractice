package com.test.spring6.iocxml;

import java.util.Map;

public class ClassWithMap {

    public Map<Integer, BasicClass> classes;

    public Map<Integer, BasicClass> getClasses() {
        return classes;
    }

    public void setClasses(Map<Integer, BasicClass> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "ClassWithMap{" +
                "classes=" + classes +
                '}';
    }
}
