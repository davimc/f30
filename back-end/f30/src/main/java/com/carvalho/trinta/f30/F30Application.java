package com.carvalho.trinta.f30;

import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.domains.Endereco;
import com.carvalho.trinta.f30.repositories.ClienteRepository;
import com.carvalho.trinta.f30.repositories.EnderecoRepository;
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
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Override
	public void run(String... args) throws Exception {


		Cliente c1 = new Cliente("Davi","607.272.893-65", "davimatosc@hotmail.com", LocalDate.of(2022,04,03),LocalDate.of(1995,06,02));
		Cliente c2 = new Cliente("Murilo","273.852.070-73", "louro@gmail.com",LocalDate.of(2022,03,01), LocalDate.of(2004,07,27));

		c1.getTelefone().addAll(Arrays.asList("982186943", "984121438"));
		c2.getTelefone().addAll(Arrays.asList("982165423"));

		clienteRepository.saveAll(Arrays.asList(c1,c2));

		Endereco e1 = new Endereco("casa", "Rua dos prazeres", "Centro", "537", null,null,"65020-460", c1);
		Endereco e2 = new Endereco ("Rua dos Manacás", "São Francisco", "7", "Quadra 7", null, "65076-210",c1);
		Endereco e3 = new Endereco ("Rua dos Manacás", "São Francisco", "8", "Quadra 7", null, "65033-258",c2);
		Endereco e4 = new Endereco ("Escola","Rua do Egito", "Centro", "S/N", null, "Na sala 28", "65075-460",c2);

		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
	}
}
