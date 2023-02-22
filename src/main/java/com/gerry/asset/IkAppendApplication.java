package com.gerry.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kouyy
 */
@ComponentScan("com.gerry.asset")
@SpringBootApplication()
public class IkAppendApplication
{
    public static void main(String[] args) {
        SpringApplication.run(IkAppendApplication.class, args);
    }
}
