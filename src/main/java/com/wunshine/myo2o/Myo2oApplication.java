package com.wunshine.myo2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.wunshine.myo2o.mapper")
@EnableTransactionManagement
@ImportResource(locations = {"classpath:kaptcha.xml"})
public class Myo2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(Myo2oApplication.class, args);
    }

}
