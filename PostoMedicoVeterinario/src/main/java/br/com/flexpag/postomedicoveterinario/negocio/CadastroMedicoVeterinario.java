package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioMedicoVeterinario;

public class CadastroMedicoVeterinario {
	private IRepositorioMedicoVeterinario repMedicoVeterinario;
	
	public CadastroMedicoVeterinario(IRepositorioMedicoVeterinario repMedicoVeterinario) {
		this.repMedicoVeterinario = repMedicoVeterinario;
	}
	
	public void incluir() {
		this.repMedicoVeterinario.incluir();
	}
	
	public void alterar() {
		this.repMedicoVeterinario.alterar();
	}
	
	public void consultar() {
		this.repMedicoVeterinario.consultar();
	}
	
	public void listar() {
		this.repMedicoVeterinario.listar();
	}
	
	public void excluir() {
		this.repMedicoVeterinario.excluir();
	}
}
