package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;

public interface IRepositorioAtendimento {
	public void incluir(Atendimento novoAtendimento) throws ClassNotFoundException, IOException, Exception;
	public void alterar(Atendimento altAtendimento) throws ClassNotFoundException, IOException, Exception;
	public ArrayList<Atendimento> listar() throws ClassNotFoundException, IOException, Exception;
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception;
}
