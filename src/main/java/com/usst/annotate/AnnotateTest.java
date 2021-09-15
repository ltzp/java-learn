package com.usst.annotate;

import java.lang.reflect.InvocationTargetException;

public class AnnotateTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Doctor doctor = new Doctor();
        doctor.setId(10);
        doctor.setName("zhangsan");
        SqlFactor.getQuerySql(doctor);
    }
}
