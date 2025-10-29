package com.example.grafana_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GrafanaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrafanaAppApplication.class, args);
	}

}
