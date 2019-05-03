package shu.ces.filmsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FilmsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmsystemApplication.class, args);
    }

}
