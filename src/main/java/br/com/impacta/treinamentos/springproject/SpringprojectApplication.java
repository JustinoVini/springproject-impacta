package br.com.impacta.treinamentos.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vinicius
 *
 * Projeto de apresentação Java Web com Framework Springboot em sua versão 2.7.1 das organizações Impacta/Qintess.
 * Para utilização do projeto será necessário abrir o browser com o seguinte link
 * http://localhost:8080/students/
 *
 * O projeto é um simples CRUD(Create, read, update and Delete) com JPA, HIBERNATE e Thymeleaf.
 *
 */

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
