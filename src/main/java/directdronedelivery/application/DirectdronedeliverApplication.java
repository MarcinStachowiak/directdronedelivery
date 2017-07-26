package directdronedelivery.application;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"directdronedelivery"})
public class DirectdronedeliverApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DirectdronedeliverApplication.class, args);
		   System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	}
}
