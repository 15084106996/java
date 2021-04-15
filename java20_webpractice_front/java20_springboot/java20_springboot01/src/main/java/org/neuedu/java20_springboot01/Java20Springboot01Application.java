package org.neuedu.java20_springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.neuedu.java20_springboot01.mapper")
public class Java20Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Java20Springboot01Application.class, args);
    }

}
