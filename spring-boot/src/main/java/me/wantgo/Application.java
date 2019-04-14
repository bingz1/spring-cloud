package me.wantgo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author zxb
 * @date 7/1/16
 */
@SpringBootApplication
@MapperScan("me.wantgo.*.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
