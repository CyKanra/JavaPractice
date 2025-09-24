package com.javapractice.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAopApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("aop-context.xml")) {
            GreetingService svc = ctx.getBean(GreetingService.class);
//            GreetingService svc = new GreetingServiceImpl();
            String result = svc.hello("Java");
            System.out.println("result = " + result);
        }
    }
}
