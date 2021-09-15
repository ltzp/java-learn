package com.usst.annotate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SqlFactor {

    public static String getQuerySql(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        Class<?> aClass = object.getClass();
        boolean flag = aClass.isAnnotationPresent(Table.class);
        if (!flag){
            return null;
        }
        Table table = aClass.getAnnotation(Table.class);
        String tableName = table.name();
        sql.append("select * from ").append(tableName).append(" where 1 = 1");
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length ; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            boolean annotationPresent = field.isAnnotationPresent(Cloumn.class);
            if(!annotationPresent){
                continue;
            }
            Cloumn cloumn = field.getAnnotation(Cloumn.class);
            String cloumnName = cloumn.name();
            String type = cloumn.type();
            Object filedValue = null;
            StringBuilder methodEnd = new StringBuilder();
            if(cloumnName.contains("_")){
                String[] s = cloumnName.split("_");
                for (String m:s) {
                    methodEnd.append( m.substring(0,1).toUpperCase()).append(m.substring(1));
                }

            }else {
                methodEnd.append( cloumnName.substring(0,1).toUpperCase()).append(cloumnName.substring(1));
            }
            String methodName = "get" + methodEnd.toString();
            Method method = aClass.getMethod(methodName);
            Object invoke = method.invoke(object, null);
            if (invoke == null || (invoke instanceof Integer && (Integer)invoke == 0 )){
                continue;
            }
            if (invoke instanceof String){
                sql.append(" and ").append(cloumnName).append("='").append(invoke).append("'");
            } else if (invoke instanceof Integer) {
                sql.append(" and ").append(cloumnName).append("=").append(invoke).append("");
            }
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
}
