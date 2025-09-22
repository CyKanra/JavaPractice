package com.javapractice.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler  implements InvocationHandler {

    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[代理] " + method.getName() + " 開始");
        long start = System.nanoTime();

        Object result = method.invoke(target, args);  // ← 反射で実体呼び出し

        long ms = (System.nanoTime() - start) / 1_000_000;
        System.out.println("[代理] " + method.getName() + " 終了, 処理時間: " + ms + "ms");
        return result;
    }
}
