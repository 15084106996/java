package org.neuedu.java20vblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.neuedu.java20vblog.mapper")
public class Java20vblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java20vblogApplication.class, args);
    }

}
