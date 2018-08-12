package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.com.flexpag.postomedicoveterinario.bancodados.BancoMysql;
import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;

public class RepositorioAtendimento implements IRepositorioAtendimento {
	private BancoMysql banco;
	
	public RepositorioAtendimento() {
		if(this.banco == null)
			this.banco = new BancoMysql();
	}
	
	public void incluir(Atendimento novoAtendimento) throws ClassNotFoundException, IOException, Exception {
		int idMedicoVeterinario = novoAtendimento.getIdMedicoVeterinario();
		int idAnimal = novoAtendimento.getIdAnimal();
		boolean urgencia = novoAtendimento.getUrgencia();
		
		Connection conn = banco.conectar();
		String query = "insert into atendimento (idMedicoVeterinario, idAnimal, urgencia) values(?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, idMedicoVeterinario);
		statement.setInt(2, idAnimal);
		statement.setBoolean(3, urgencia);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
	
	public void alterar(Atendimento altAtendimento) throws ClassNotFoundException, IOException, Exception {
		int id = altAtendimento.getId();
		int idMedicoVeterinario = altAtendimento.getIdMedicoVeterinario();
		int idAnimal = altAtendimento.getIdAnimal();
		boolean urgencia = altAtendimento.getUrgencia();
		
		Connection conn = banco.conectar();
		String query = "update atendimento set idMedicoVeterinario = ?, idAnimal = ?, urgencia = ? where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, idMedicoVeterinario);
		statement.setInt(2, idAnimal);
		statement.setBoolean(3, urgencia);
		statement.setInt(4, id);
		
		statement.execute();

		conn = banco.desconectar();		
	}
	
	public ArrayList<Atendimento> listar() throws ClassNotFoundException, IOException, Exception {
		ArrayList<Atendimento> listAtendimento = new ArrayList<Atendimento>();
		
		String query = "select id, idmedicoveterinario, idanimal, urgencia from atendimento";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int id = rs.getInt("id");
			int idMedicoVeterinario = rs.getInt("idmedicoveterinario");
			int idAnimal = rs.getInt("idanimal");
			boolean urgencia = rs.getBoolean("urgencia");
			
			Atendimento atendimento = new Atendimento(id, idMedicoVeterinario, idAnimal, urgencia);
			listAtendimento.add(atendimento);
		}
		
		conn = banco.desconectar();
	
		return listAtendimento;
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		Connection conn = banco.conectar();
		String query = "delete from atendimento where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
}
