package cl.usach.mingeso.proveedorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProveedorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProveedorServiceApplication.class, args);
    }

}
