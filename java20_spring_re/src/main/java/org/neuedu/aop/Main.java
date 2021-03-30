package org.neuedu.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AOPTest aopTest = context.getBean("AOPTest", AOPTest.class);
        aopTest.show();
    }
}
