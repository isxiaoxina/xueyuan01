package com.cxxx.eduservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package ：com.cxxx.eduservice
 * @ClassName：EduApplication
 * @date ：2021/9/1814:50
 * @Description：
 */

@SpringBootApplication
@ComponentScan(basePackages ={"com.cxxx"} )//要扫描 才能把service-base类搞出来
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);


    }




}
