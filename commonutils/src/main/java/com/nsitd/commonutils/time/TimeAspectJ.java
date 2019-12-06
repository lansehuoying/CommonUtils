package com.nsitd.commonutils.time;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TimeAspectJ {
    private static final String TAG = "TimeAspectJ";

    @Pointcut("execution(@com.nsitd.commonutils.time.TimeStatistics * *(..))")
    public void timeStatistics() { }

    @Around("timeStatistics()")
    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取方法的签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        //注解值
        String value = methodSignature.getMethod().getAnnotation(TimeStatistics.class).value();
        long before = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() - before;
        Toast.makeText((Context) joinPoint.getThis(),""+duration,Toast.LENGTH_SHORT).show();
        Log.d(TAG, String.format("统计了：%s功能，在%s类下的%s方法，用时%d ms",value,className,methodName,duration));

        return proceed;
    }

}
