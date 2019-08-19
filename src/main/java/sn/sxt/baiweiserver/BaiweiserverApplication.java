package sn.sxt.baiweiserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "sn.sxt.baiweiserver.mapper" )
public class BaiweiserverApplication {

    public static void main(String[] args) {

        SpringApplication.run(BaiweiserverApplication.class, args);
    }

}
