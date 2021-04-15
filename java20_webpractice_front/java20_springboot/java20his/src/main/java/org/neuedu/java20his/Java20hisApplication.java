package org.neuedu.java20his;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.neuedu.java20his")
public class Java20hisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java20hisApplication.class, args);
    }

}
