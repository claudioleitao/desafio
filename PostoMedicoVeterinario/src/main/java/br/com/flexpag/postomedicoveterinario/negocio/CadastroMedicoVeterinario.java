package br.com.flexpag.postomedicoveterinario.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioMedicoVeterinario;

public class CadastroMedicoVeterinario {
	private IRepositorioMedicoVeterinario repMedicoVeterinario;
	
	public CadastroMedicoVeterinario(IRepositorioMedicoVeterinario repMedicoVeterinario) {
		this.repMedicoVeterinario = repMedicoVeterinario;
	}
	
	public void incluir(MedicoVeterinario novoMedicoVeterinario) throws ClassNotFoundException, IOException, Exception {
		this.repMedicoVeterinario.incluir(novoMedicoVeterinario);
	}
	
	public void alterar(MedicoVeterinario altMedicoVeterinario) throws ClassNotFoundException, IOException, Exception {
		this.repMedicoVeterinario.alterar(altMedicoVeterinario);
	}
	
	public MedicoVeterinario consultar(String nome) throws ClassNotFoundException, IOException, Exception {
		return this.repMedicoVeterinario.consultar(nome);
	}
	
	public ArrayList<MedicoVeterinario> listar() throws ClassNotFoundException, IOException, Exception {
		return this.repMedicoVeterinario.listar();
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		this.repMedicoVeterinario.excluir(id);
	}
}
