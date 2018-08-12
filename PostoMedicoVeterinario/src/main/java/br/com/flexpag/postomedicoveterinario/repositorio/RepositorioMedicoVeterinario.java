package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.com.flexpag.postomedicoveterinario.bancodados.BancoMysql;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;

public class RepositorioMedicoVeterinario implements IRepositorioMedicoVeterinario {
	private BancoMysql banco;
	
	public RepositorioMedicoVeterinario() {
		if(this.banco == null)
			this.banco = new BancoMysql();
	}
	
	public void incluir(MedicoVeterinario novoMedico) throws ClassNotFoundException, IOException, Exception {
		String nome = novoMedico.getNome();
		String sexo = novoMedico.getSexo();
		String especialidade = novoMedico.getEspecialidade();
		
		Connection conn = banco.conectar();
		String query = "insert into medicoveterinario (nome, sexo, especialidade) values(?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nome);
		statement.setString(2, sexo);
		statement.setString(3, especialidade);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
	
	public void alterar(MedicoVeterinario altMedico) throws ClassNotFoundException, IOException, Exception {
		int id = altMedico.getId();
		String nome = altMedico.getNome();
		String sexo = altMedico.getSexo();
		String especialidade = altMedico.getEspecialidade();
		
		Connection conn = banco.conectar();
		String query = "update medicoveterinario set nome = ?, sexo = ?, especialidade = ? where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nome);
		statement.setString(2, sexo);
		statement.setString(3, especialidade);
		statement.setInt(4, id);
		
		statement.execute();

		conn = banco.desconectar();		
	}
	
	public MedicoVeterinario consultar(String nome) throws ClassNotFoundException, IOException, Exception {
		String query = "select id, nome, sexo, especialidade from medicoveterinario where nome = '"+nome+"'";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome1 = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especialidade = rs.getString("especialidade");
		
			conn = banco.desconectar();
			
			return new MedicoVeterinario(id, nome1, sexo, especialidade);
		}
	
		return null;
	}
	
	public MedicoVeterinario consultar(int id) throws ClassNotFoundException, IOException, Exception {
		String query = "select id, nome, sexo, especialidade from medicoveterinario where id = '"+id+"'";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int idMedico = rs.getInt("id");
			String nome1 = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especialidade = rs.getString("especialidade");
		
			conn = banco.desconectar();
			
			return new MedicoVeterinario(idMedico, nome1, sexo, especialidade);
		}
	
		return null;
	}
	
	public ArrayList<MedicoVeterinario> listar() throws ClassNotFoundException, IOException, Exception {
		ArrayList<MedicoVeterinario> listMedicoVeterinario = new ArrayList<MedicoVeterinario>();
		
		String query = "select id, nome, sexo, especialidade from medicoveterinario";

		Connection conn = banco.conectar();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
	
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String sexo = rs.getString("sexo");
			String especialidade = rs.getString("especialidade");
			
			MedicoVeterinario medicoVeterinario = new MedicoVeterinario(id, nome, sexo, especialidade);
			
			listMedicoVeterinario.add(medicoVeterinario);
		}
		
		conn = banco.desconectar();
	
		return listMedicoVeterinario;
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		Connection conn = banco.conectar();
		String query = "delete from medicoveterinario where id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		
		statement.execute();
		
		conn = banco.desconectar();
	}
}
