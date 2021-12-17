package com.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class ConfigClientApplication {

    Logger log = Logger.getLogger(ConfigClientApplication.class.getName());
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
        log.info("\n\tprofile：" + profile
                + "\n\tname：" + name
                + "\n\tdesc：" + desc);
        return "profile：" + profile + "<br>"
                + "name：" + name + "<br>"
                + "desc：" + desc;
    }
}
