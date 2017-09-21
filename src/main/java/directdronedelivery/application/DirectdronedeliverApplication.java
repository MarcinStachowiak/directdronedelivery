package directdronedelivery.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "directdronedelivery" })
public class DirectdronedeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectdronedeliverApplication.class, args);
    }
}
