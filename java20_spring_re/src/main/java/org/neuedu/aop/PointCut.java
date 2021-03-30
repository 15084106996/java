package org.neuedu.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointCut {
    @Pointcut("execution(* org.neuedu.aop.AOPTest.show())")
    public void test1() {}
}
