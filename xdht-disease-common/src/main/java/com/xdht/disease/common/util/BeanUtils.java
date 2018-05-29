package com.xdht.disease.common.util;

import com.xdht.disease.common.authorization.annotation.TargetName;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanUtils {

    public static void copy(Object source, Object target) throws Exception{

        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();


        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();


        for (Field field : targetFields) {

            TargetName targetName = field.getAnnotation(TargetName.class);

            if (targetName != null) {

                field.setAccessible(true);

                String value = targetName.value();

                String type = targetName.type();

                if (value.contains(".")) {
                    String[] vs = value.split("\\.");

                    for (Field sourceField : sourceFields) {

                        if (sourceField.getName().equals(vs[0])) {
                            sourceField.setAccessible(true);

                            Object subValue = sourceField.get(source);

                            Class subClass = subValue.getClass();

                            Method m = subClass.getMethod(vs[1]);
                            if (StringUtils.isEmpty(type)) {
                                field.set(target, m.invoke(subValue));
                            } else {
                                field.set(target, String.valueOf(m.invoke(subValue)));
                            }
                        }
                    }
                } else if (value.contains(",")) {

                    String[] vs = value.split(",");
                    String last = "";

                    for (String vt : vs) {

                        Field sourceField = getDeclaredField(source, vt);
                        if (sourceField == null) {
                            continue;
                        }

                        sourceField.setAccessible(true);

                        last += sourceField.get(source) + ";";
                    }

                    field.set(target, last);
                } else {

                    Field sourceField = getDeclaredField(source, value);
                    if (sourceField == null) {
                        continue;
                    }
                    sourceField.setAccessible(true);

                    if (StringUtils.isEmpty(type)) {

                        field.set(target, sourceField.get(source));
                    } else {

                        if ("java.lang.String".equals(field.getType().getName())) {
                            field.set(target, String.valueOf(sourceField.get(source)));
                        }
                    }
                }
            }
        }

    }

    public static Field getDeclaredField(Object object, String fieldName){
        Field field = null ;

        Class<?> clazz = object.getClass() ;

        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName) ;
                return field ;
            } catch (Exception e) {
            }
        }

        return null;
    }
}
