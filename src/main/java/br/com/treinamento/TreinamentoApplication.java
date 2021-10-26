package br.com.treinamento;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinamento.dao.InterfaceCliente;
import br.com.treinamento.model.Clientes;

@SpringBootApplication
public class TreinamentoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoApplication.class, args);
	}

	@Autowired
	InterfaceCliente dao;
	
	@Override
	public void run(String... args) throws Exception {
	//	List<Clientes> clientes = dao.buscaClientes(); 
	//	System.out.println(clientes);
	//	for(Clientes c : clientes){ 
	//		System.out.println(c.getNome()); 
	//		System.out.println(c.getSobrenome());
	//	}

	Clientes cli = new Clientes();
	cli.setDataNascimento(new Date());
	cli.setEmail("exemple@gmail.com");
	cli.setNome("luis");
	cli.setSobrenome("Gama");
    cli.setId(8l);
	//dao.salvarCliente(cli);
	dao.atualizarCliente(cli);
	}

	
	
	
	
}
