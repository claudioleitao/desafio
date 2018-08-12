package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioAnimal {
	public void incluir(Object novoAnimal) throws ClassNotFoundException, IOException, Exception;
	public void alterar(Object novoAnimal) throws ClassNotFoundException, IOException, Exception;
	public Object consultar(String nomeAnimal) throws ClassNotFoundException, IOException, Exception;
	public ArrayList<Object> listar() throws ClassNotFoundException, IOException, Exception;
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception;
}
