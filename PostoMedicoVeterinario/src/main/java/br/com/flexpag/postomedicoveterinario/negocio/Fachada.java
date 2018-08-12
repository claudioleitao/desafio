package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioMedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioMedicoVeterinario;

public class Fachada {
	private FabricaRepositorio fabrica;
	private Fachada instancia;
	
	private CadastroAnimal cadAnimal;
	private CadastroMedicoVeterinario cadMedicoVeterinario;
	private CadastroAtendimento cadAtendimento;
	
	private Fachada() {
		
	}
	
	public Fachada getInstance() {
		if (this.instancia == null)
			this.instancia = new Fachada();
		
		return this.instancia;
	}
	
	public void iniciarCadastro() {
		this.fabrica = new FabricaRepositorio();
		IRepositorioAnimal repAnimal = (RepositorioAnimal) fabrica.criarRepositorioAnimal();
		IRepositorioMedicoVeterinario repMedicoVeterinario = (RepositorioMedicoVeterinario) fabrica.criarRepositorioMedicoVeterinario();
		IRepositorioAtendimento repAtendimento = (RepositorioAtendimento) fabrica.criarRepositorioAtendimento();
		
		this.cadAnimal = new CadastroAnimal(repAnimal);
		this.cadMedicoVeterinario = new CadastroMedicoVeterinario(repMedicoVeterinario);
		this.cadAtendimento = new CadastroAtendimento(repAtendimento);
	}
	
	public void incluirAnimal() {
		this.cadAnimal.incluir();
	}
	
	public void alterarAnimal() {
		this.cadAnimal.alterar();
	}
	
	public void consultarAnimal() {
		this.cadAnimal.consultar();
	}
	
	public void listarAnimal() {
		this.cadAnimal.listar();
	}
	
	public void excluirAnimal() {
		this.cadAnimal.excluir();
	}
	
	public void incluirMedicoVeterinario() {
		this.cadMedicoVeterinario.incluir();
	}
	
	public void alterarMedicoVeterinario() {
		this.cadMedicoVeterinario.alterar();
	}
	
	public void consultarMedicoVeterinario() {
		this.cadMedicoVeterinario.consultar();
	}
	
	public void listarMedicoVeterinario() {
		this.cadMedicoVeterinario.listar();
	}
	
	public void excluirMedicoVeterinario() {
		this.cadMedicoVeterinario.excluir();
	}
	
	public void incluirAtendimento() {
		this.cadAtendimento.incluir();
	}
	
	public void alterarAtendimento() {
		this.cadAtendimento.alterar();
	}
	
	public void consultarAtendimento() {
		this.cadAtendimento.consultar();
	}
	
	public void listarAtendimento() {
		this.cadAtendimento.listar();
	}
	
	public void excluirAtendimento() {
		this.cadAtendimento.excluir();
	}
}
