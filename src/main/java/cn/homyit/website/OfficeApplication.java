package cn.homyit.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author 州牧
 * @description
 * @since 2022-08-15 21:14
 */
@ComponentScan("cn.homyit")
@MapperScan("cn.homyit.website.mapper")
@SpringBootApplication
public class OfficeApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }
}

