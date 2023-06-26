package cl.usach.mingeso.laboratorioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LaboratorioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratorioServiceApplication.class, args);
    }

}
