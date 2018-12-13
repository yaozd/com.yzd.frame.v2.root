package com.yzd.web.api.utils.aspectExt;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AspectUtil {
    //获得当前方法
    public static Method getMethod(ProceedingJoinPoint jp) {
        MethodSignature sign = (MethodSignature) jp.getSignature();
        Method method = sign.getMethod();
        return method;
    }
    //获得当前方法的注解信息
    public static <T extends Annotation> T getAnnotation(Method method, Class<T> clazz) {
        return method.getAnnotation(clazz);
    }
}
