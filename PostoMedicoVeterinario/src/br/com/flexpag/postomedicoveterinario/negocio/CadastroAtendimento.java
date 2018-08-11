package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAtendimento;

public class CadastroAtendimento {
	private IRepositorioAtendimento repAtendimento;
	
	public CadastroAtendimento(IRepositorioAtendimento repAtendimento) {
		this.repAtendimento = repAtendimento;
	}
	
	public void incluir() {
		this.repAtendimento.incluir();
	}
	
	public void alterar() {
		this.repAtendimento.alterar();
	}
	
	public void consultar() {
		this.repAtendimento.consultar();
	}
	
	public void listar() {
		this.repAtendimento.listar();
	}
	
	public void excluir() {
		this.repAtendimento.excluir();
	}
}
