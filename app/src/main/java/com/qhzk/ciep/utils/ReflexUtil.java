package com.qhzk.ciep.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Thisdk on 2016/5/7.
 * 反射工具类
 */
public class ReflexUtil {

    public static <T> Class<T> getClassGeneric(Object obj, int index) {
        try {
            Type genericSuperclass = obj.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > index) {
                    return (Class<T>) actualTypeArguments[index];
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
