package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.com.flexpag.postomedicoveterinario.bancodados.BancoMysql;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;

public class RepositorioAnimal implements IRepositorioAnimal {
	private BancoMysql banco;
	
	public RepositorioAnimal() {
		if(this.banco == null)
			this.banco = new BancoMysql();
	}
	
	public void incluir(Object novoAnimal) throws ClassNotFoundException, IOException, Exception {
		String nomeAnimal = "";
		String sexo = "";
		String especie = "";
		String raca = "";
		
		if (novoAnimal.getClass() == Cachorro.class) {
			Cachorro cachorro = (Cachorro) novoAnimal;
			nomeAnimal = cachorro.getNome();
			sexo = cachorro.getSexo();
			especie = "Cachorro";
			raca = cachorro.getRaca();
		} else if (novoAnimal.getClass() == Gato.class) {
			Gato gato = (Gato) novoAnimal;
			nomeAnimal = gato.getNome();
			sexo = gato.getSexo();
			especie = "Gato";
			raca = gato.getRaca();
		} else  if (novoAnimal.getClass() == Hamster.class) {
			Hamster hamster = (Hamster) novoAnimal;
			nomeAnimal = hamster.getNome();
			sexo = hamster.getSexo();
			especie = "Hamster";
			raca = hamster.getRaca();
		}
		
		Connection conn = banco.conectar();
		String query = "insert into animal (nome, sexo, especie, raca) values(?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nomeAnimal);
		statement.setString(2, sexo);
		statement.setString(3, especie);
		statement.setString(4, raca);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
	
	public void alterar(Object altAnimal) throws ClassNotFoundException, IOException, Exception {
		int id = 0;
		String nomeAnimal = "";
		String sexo = "";
		String especie = "";
		String raca = "";
		
		if (altAnimal.getClass() == Cachorro.class) {
			Cachorro cachorro = (Cachorro) altAnimal;
			id = cachorro.getId();
			nomeAnimal = cachorro.getNome();
			sexo = cachorro.getSexo();
			especie = "Cachorro";
			raca = cachorro.getRaca();
		} else if (altAnimal.getClass() == Gato.class) {
			Gato gato = (Gato) altAnimal;
			id = gato.getId();
			nomeAnimal = gato.getNome();
			sexo = gato.getSexo();
			especie = "Gato";
			raca = gato.getRaca();
		} else if (altAnimal.getClass() == Hamster.class) {
			Hamster hamster = (Hamster) altAnimal;
			id = hamster.getId();
			nomeAnimal = hamster.getNome();
			sexo = hamster.getSexo();
			especie = "Hamster";
			raca = hamster.getRaca();
		}
		
		Connection conn = banco.conectar();
		String query = "update animal set nome = ?, sexo = ?, especie = ?, raca = ? where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nomeAnimal);
		statement.setString(2, sexo);
		statement.setString(3, especie);
		statement.setString(4, raca);
		statement.setInt(5, id);
		
		statement.execute();

		conn = banco.desconectar();		
	}
	
	public Object consultar(String nome) throws ClassNotFoundException, IOException, Exception {
		String query = "select id, nome, sexo, especie, raca from animal where nome = '"+nome+"'";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int id = rs.getInt("id");
			String nomeAnimal = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especie = rs.getString("especie");
			String raca = rs.getString("raca");
		
			conn = banco.desconectar();
			
			if (especie.equalsIgnoreCase("Cachorro")) {
				Cachorro cachorro = new Cachorro(id, nomeAnimal, sexo, raca);
				return cachorro;
			} else if (especie.equalsIgnoreCase("Gato")) {
				Gato gato = new Gato(id, nomeAnimal, sexo, raca);
				return gato;
			} else if (especie.equalsIgnoreCase("Hamster")) {
				Hamster hamster = new Hamster(id, nomeAnimal, sexo, raca);
				return hamster;
			}
		}
	
		return null;
	}
	
	public Object consultar(int id) throws ClassNotFoundException, IOException, Exception {
		String query = "select id, nome, sexo, especie, raca from animal where id = '"+id+"'";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int idAnimal = rs.getInt("id");
			String nomeAnimal = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especie = rs.getString("especie");
			String raca = rs.getString("raca");
		
			conn = banco.desconectar();
			
			if (especie.equalsIgnoreCase("Cachorro")) {
				Cachorro cachorro = new Cachorro(idAnimal, nomeAnimal, sexo, raca);
				return cachorro;
			} else if (especie.equalsIgnoreCase("Gato")) {
				Gato gato = new Gato(idAnimal, nomeAnimal, sexo, raca);
				return gato;
			} else if (especie.equalsIgnoreCase("Hamster")) {
				Hamster hamster = new Hamster(idAnimal, nomeAnimal, sexo, raca);
				return hamster;
			}
		}
	
		return null;
	}
	
	public ArrayList<Object> listar() throws ClassNotFoundException, IOException, Exception {
		ArrayList<Object> listObjects = new ArrayList<Object>();
		
		String query = "select id, nome, sexo, especie, raca from animal";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int id = rs.getInt("id");
			String nomeAnimal = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especie = rs.getString("especie");
			String raca = rs.getString("raca");
			
			if (especie.equalsIgnoreCase("Cachorro")) {
				Cachorro cachorro = new Cachorro(id, nomeAnimal, sexo, raca);
				listObjects.add(cachorro);
			} else if (especie.equalsIgnoreCase("Gato")) {
				Gato gato = new Gato(id, nomeAnimal, sexo, raca);
				listObjects.add(gato);
			} else if (especie.equalsIgnoreCase("Hamster")) {
				Hamster hamster = new Hamster(id, nomeAnimal, sexo, raca);
				listObjects.add(hamster);
			}
		}
		
		conn = banco.desconectar();
	
		return listObjects;
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		Connection conn = banco.conectar();
		String query = "delete from animal where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
}
