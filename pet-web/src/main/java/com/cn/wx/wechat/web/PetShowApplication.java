package com.cn.wx.wechat.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: pet-show
 * @description: 宠宠秀启动类
 * @author: king
 * @create: 2018-07-09 20:25
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.cn.wx.wechat")
@MapperScan("com.cn.wx.wechat.dal")
public class PetShowApplication {

    public static void main(String[] args) {

        SpringApplication.run(PetShowApplication.class, args);
    }

}
