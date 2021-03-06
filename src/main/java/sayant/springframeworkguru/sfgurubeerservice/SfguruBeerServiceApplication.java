package sayant.springframeworkguru.sfgurubeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SfguruBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfguruBeerServiceApplication.class, args);
    }

}
