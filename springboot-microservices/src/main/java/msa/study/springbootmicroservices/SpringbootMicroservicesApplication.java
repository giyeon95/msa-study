package msa.study.springbootmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroservicesApplication.class, args);
	}

}
