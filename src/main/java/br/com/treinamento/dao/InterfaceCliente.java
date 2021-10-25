package br.com.treinamento.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.treinamento.model.Clientes;
@Repository
public interface InterfaceCliente {

	public void salvarCliente(Clientes cliente);	
	public void atualizarCliente(Clientes cliente);
	public List<Clientes> buscaClientes();
	public void excluiCliente(Clientes cliente);
	
}
