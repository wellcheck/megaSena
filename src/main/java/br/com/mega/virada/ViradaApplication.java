package br.com.mega.virada;

import br.com.mega.virada.service.MegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ViradaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ViradaApplication.class, args);

	}
}
