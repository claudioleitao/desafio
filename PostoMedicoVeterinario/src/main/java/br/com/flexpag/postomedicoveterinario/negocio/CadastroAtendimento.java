package br.com.flexpag.postomedicoveterinario.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAtendimento;

public class CadastroAtendimento {
	private IRepositorioAtendimento repAtendimento;
	
	public CadastroAtendimento(IRepositorioAtendimento repAtendimento) {
		this.repAtendimento = repAtendimento;
	}
	
	public void incluir(Atendimento novoAtendimento) throws ClassNotFoundException, IOException, Exception {
		this.repAtendimento.incluir(novoAtendimento);
	}
	
	public void alterar(Atendimento altAtendimento) throws ClassNotFoundException, IOException, Exception {
		this.repAtendimento.alterar(altAtendimento);
	}
	
	public ArrayList<Atendimento> listar() throws ClassNotFoundException, IOException, Exception {
		return this.repAtendimento.listar();
	}
	
	public void excluir(int id) throws ClassNotFoundException, IOException, Exception {
		this.repAtendimento.excluir(id);
	}
}
