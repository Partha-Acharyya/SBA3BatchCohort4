package com.wf.bootapp.ibs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wf.bootapp.ibs"})
@EnableJpaRepositories(basePackages = { "com.wf.bootapp.ibs" })
@EntityScan("com.wf.bootapp.ibs")
//@ComponentScan("com.wf.bootapp.ibs")
public class BootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}

}
