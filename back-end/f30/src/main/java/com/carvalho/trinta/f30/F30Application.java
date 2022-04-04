package com.carvalho.trinta.f30;

import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

@SpringBootApplication
public class F30Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(F30Application.class, args);
	}
	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente("Davi","60727289365", "davimatosc@hotmail.com", LocalDate.of(2022,04,03),LocalDate.of(1995,06,02));
		Cliente c2 = new Cliente("Murilo","273.852.070-73", "louro@gmail.com",LocalDate.of(2022,03,01), LocalDate.of(2004,07,27));

		c1.getTelefone().addAll(Arrays.asList("982186943", "984121438"));
		c2.getTelefone().addAll(Arrays.asList("982165423"));

		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
}
