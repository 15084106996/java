package org.neuedu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdviceOfMine {
    @Before("org.neuedu.aop.PointCut.test1()")
    public void before() {
        System.out.println("前置");
    }
}
