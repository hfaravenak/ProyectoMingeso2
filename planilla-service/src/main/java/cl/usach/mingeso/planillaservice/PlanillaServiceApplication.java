package cl.usach.mingeso.planillaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlanillaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanillaServiceApplication.class, args);
    }

}
