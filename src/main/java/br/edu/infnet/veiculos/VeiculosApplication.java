package br.edu.infnet.veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VeiculosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeiculosApplication.class, args);
    }

}
