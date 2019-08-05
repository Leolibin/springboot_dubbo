package com.sugon.springboot_dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootAllProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAllProviderApplication.class, args);
    }

}
