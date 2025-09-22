package com.javapractice.pattern;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static void main(String[] args) {
        // 実体
        DynamicSevice target = new DynamicSeviceImpl();

        // 代理を生成
        DynamicSevice proxy = (DynamicSevice) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{DynamicSevice.class},      // インターフェース必須
                new LoggingHandler(target)       // 横断処理
        );

        // 呼び出し
        proxy.doWork("データ送信");
    }
}
