package com.javapractice.aop;

public class GreetingServiceImpl implements GreetingService{
    @Override
    public String hello(String name) {
        System.out.println(">> business: say hello to " + name);
        return "Hello, " + name + "!";
    }
}
