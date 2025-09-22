package com.javapractice.pattern;

public class DynamicSeviceImpl implements DynamicSevice{
    @Override
    public void doWork(String task) {
        System.out.println(">> 実際の業務ロジック: " + task);
    }
}
