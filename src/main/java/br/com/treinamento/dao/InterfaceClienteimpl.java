package br.com.treinamento.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.treinamento.model.Clientes;
@Repository
public class InterfaceClienteimpl implements InterfaceCliente, RowMapper<Clientes> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {	
		this.jdbcTemplate = new JdbcTemplate ( dataSource);
	}
	
	
	
	
	
	@Override
	public void salvarCliente(Clientes cliente) {
	
		jdbcTemplate.update(
			    "INSERT INTO clientes (id, data_nascimento, email, nome, sobrenome) VALUES (?, ?, ?, ?, ?)",
			   cliente.getId(), cliente.getDataNascimento(), cliente.getEmail(), cliente.getNome(), cliente.getSobrenome()
			);
		
	}

	@Override
	public void atualizarCliente(Clientes cliente) {
		StringBuilder sql = new StringBuilder();
		
		List<Object>  paramentros = new ArrayList<Object>();
		paramentros.add(cliente.getNome());
		paramentros.add(cliente.getSobrenome());
		paramentros.add(cliente.getDataNascimento());
		paramentros.add(cliente.getEmail());
		paramentros.add(cliente.getId());
		
		sql.append("update clientes ");
		sql.append("SET         nome   = ?, ");
		sql.append("sobrenome = ?, ");
		sql.append("data_nascimento = ?, ");
		sql.append("email = ? ");
		sql.append("where id = ? ");
		
		jdbcTemplate.update(sql.toString(),paramentros.toArray());
			 
	}

	
	@Override
	public List<Clientes> buscaClientes() {

		String sql = "SELECT * FROM clientes";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Clientes.class));
	
	}
	

	@Override
	public void excluiCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public Clientes mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
