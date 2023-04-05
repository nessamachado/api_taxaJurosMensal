package com.vanessa.api_taxaJurosMensal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiTaxaJurosMensalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTaxaJurosMensalApplication.class, args);
	}

}
