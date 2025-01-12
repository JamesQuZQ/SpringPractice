package com.test.reflection;

import org.junit.Test;

import java.lang.reflect.*;

public class TestCar {

    @Test
    public void testObtainClassObject() throws Exception {
        Class clazz1 = Car.class;

        Class clazz2 = new Car().getClass();

        Class clazz3 = Class.forName("com.test.reflection.Car");

        // Instantiation
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    @Test
    public void testObtainClassContructor(){
        Class clazz = Car.class;
        // getConstructors only obtains public constructors;
        // getDeclaredConstructors obtains public + private constructors;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Name: " + constructor.getName() + "; Param count: " + constructor.getParameterCount());
        }
    }

    @Test
    public void testObtainClassFields() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        // getFields only obtains public fields;
        // getDeclaredFields obtains public + private fields;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name: " + field.getName() + "; Type: " + field.getType());
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "Toyota");
            }
        }
        System.out.println(car);
    }

    @Test
    public void testObtainClassMethod() throws Exception {
        Car car = new Car("Mazda", 5, "white");
        Class clazz = Car.class;
        // getMethods only obtains public methods;
        // getDeclaredMethods obtains public + private methods;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("toString")) {
                System.out.println((String)method.invoke(car));
            }
            if (method.getName().equals("run")) {
                // For private methods, we need to change the accessibility before invoking
                method.setAccessible(true);
                System.out.println("Running private method");
                method.invoke(car);
            }
        }
    }
}
