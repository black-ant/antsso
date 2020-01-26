package com.gang.antsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname AntSsoApplication
 * @Description TODO
 * @Date 2020/1/11 15:14
 * @Created by zengzg
 */
@SpringBootApplication(scanBasePackages = "com.gang")
@EnableSwagger2
public class AntSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntSsoApplication.class, args);
    }
}
