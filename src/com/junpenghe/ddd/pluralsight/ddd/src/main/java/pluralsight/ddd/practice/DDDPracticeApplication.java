package pluralsight.ddd.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("pluralsight.ddd.practice.dao")
@SpringBootApplication
public class DDDPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DDDPracticeApplication.class, args);
    }

}
