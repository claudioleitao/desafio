package br.com.flexpag.postomedicoveterinario.repositorio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;

public interface IRepositorioMedicoVeterinario {
	public void incluir(MedicoVeterinario novoMedicoVeterinario) throws ClassNotFoundException, IOException, Exception;
	public void alterar(MedicoVeterinario altMedicoVeterinario) throws ClassNotFoundException, IOException, Exception;
	public MedicoVeterinario consultar(String nome) throws ClassNotFoundException, IOException, Exception;
	public MedicoVeterinario consultar(int id) throws ClassNotFoundException, IOException, Exception;
	public ArrayList<MedicoVeterinario> listar() throws ClassNotFoundException, IOException, Exception;
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception;
}
