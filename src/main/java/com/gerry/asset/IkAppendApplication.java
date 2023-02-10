package com.gerry.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
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

    /**
     * 修改tomcat默认端口
     * @return
     */
    @Bean
    public TomcatEmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();
        container.setPort(8081);
        return container;
    }


}
