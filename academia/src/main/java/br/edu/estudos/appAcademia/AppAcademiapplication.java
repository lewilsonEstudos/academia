package br.edu.estudos.appAcademia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppAcademiapplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAcademiapplication.class, args);
	}
}
