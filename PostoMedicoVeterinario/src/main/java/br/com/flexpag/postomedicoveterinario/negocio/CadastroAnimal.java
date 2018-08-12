package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAnimal;

public class CadastroAnimal {
	private IRepositorioAnimal repAnimal;
	
	public CadastroAnimal(IRepositorioAnimal repAnimal) {
		this.repAnimal = repAnimal;
	}
	
	public void incluir() {
		this.repAnimal.incluir();
	}
	
	public void alterar() {
		this.repAnimal.alterar();
	}
	
	public void consultar() {
		this.repAnimal.consultar();
	}
	
	public void listar() {
		this.repAnimal.listar();
	}
	
	public void excluir() {
		this.repAnimal.excluir();
	}
}
