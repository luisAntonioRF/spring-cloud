package com.luis.app.oaut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioOautApplication  implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioOautApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "1234";
		
		for (int i = 0; i < 4; i++) {
			String passEncode= passwordEncoder.encode(password);
			System.out.println(passEncode);
		}
		
	}

}
