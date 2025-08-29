package com.javapractice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TimeLoggingAdvice implements MethodInterceptor {
    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        long start = System.nanoTime();
        try {
            System.out.println("------->>>>>-》[AOP] " + invocation.getMethod().getName());
            return invocation.proceed();
        } finally {
            long ms = (System.nanoTime() - start) / 1_000_000;
            System.out.println("--------》[AOP] " + invocation.getMethod().getName() + " took " + ms + " ms");
        }
    }
}
