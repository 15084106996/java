package org.neuedu.aop;

import org.springframework.stereotype.Component;

@Component("AOPTest")
public class AOPTest {
    public void show() {
        System.out.println(111);
    }
}
