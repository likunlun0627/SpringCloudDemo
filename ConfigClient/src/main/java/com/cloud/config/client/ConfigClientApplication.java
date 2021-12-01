package com.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@BootstrapConfiguration
@RestController
public class ConfigClientApplication {

    @Value("${info.profile}")
    private String profile;
    @Value("${name}")
    private String name;
    @Value("${desc}")
    private String desc;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @RequestMapping("/info")
    public String info() {
        return "profile：" + profile + "<br>"
                + "name：" + name + "<br>"
                + "desc：" + desc;
    }
}
