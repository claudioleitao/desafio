package br.com.flexpag.postomedicoveterinario.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAnimal;

public class CadastroAnimal {
	private IRepositorioAnimal repAnimal;
	
	public CadastroAnimal(IRepositorioAnimal repAnimal) {
		this.repAnimal = repAnimal;
	}
	
	public void incluir(Object novoAnimal) throws ClassNotFoundException, IOException, Exception {
		this.repAnimal.incluir(novoAnimal);
	}
	
	public void alterar(Object altAnimal) throws ClassNotFoundException, IOException, Exception {
		this.repAnimal.alterar(altAnimal);
	}
	
	public Object consultar(String nome) throws ClassNotFoundException, IOException, Exception {
		return this.repAnimal.consultar(nome);
	}
	
	public ArrayList<Object> listar() throws ClassNotFoundException, IOException, Exception {
		return this.repAnimal.listar();
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		this.repAnimal.excluir(id);
	}
}
