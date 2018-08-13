package br.com.flexpag.postomedicoveterinario.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioMedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioMedicoVeterinario;

public class Fachada {
	private FabricaRepositorio fabrica;
	private static Fachada instancia;
	
	private CadastroAnimal cadAnimal;
	private CadastroMedicoVeterinario cadMedicoVeterinario;
	private CadastroAtendimento cadAtendimento;
	
	private Fachada() {
		this.iniciarCadastro();
	}
	
	public static Fachada getInstance() {
		if (instancia == null)
			instancia = new Fachada();
		
		return instancia;
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
	
	public void incluirAnimal(String nome, String sexo, String especie, String raca) throws ClassNotFoundException, IOException, Exception {
		if (especie.equalsIgnoreCase("Cachorro")) {
			this.cadAnimal.incluir(new Cachorro(0, nome, sexo, raca));
		} else if (especie.equalsIgnoreCase("Gato")) {
			this.cadAnimal.incluir(new Gato(0, nome, sexo, raca));
		} else if (especie.equalsIgnoreCase("Hamster")) {
			this.cadAnimal.incluir(new Hamster(0, nome, sexo, raca));
		}
	}
	
	public void alterarAnimal(String nome, String sexo, String especie, String raca) throws ClassNotFoundException, IOException, Exception {
		if (especie.equalsIgnoreCase("Cachorro")) {
			this.cadAnimal.alterar(new Cachorro(0, nome, sexo, raca));
		} else if (especie.equalsIgnoreCase("Gato")) {
			this.cadAnimal.alterar(new Gato(0, nome, sexo, raca));
		} else if (especie.equalsIgnoreCase("Hamster")) {
			this.cadAnimal.alterar(new Hamster(0, nome, sexo, raca));
		}
	}
	
	public Object consultarAnimal(String nome) throws ClassNotFoundException, IOException, Exception {
		return this.cadAnimal.consultar(nome);
	}
	
	public Object consultarAnimal(int id) throws ClassNotFoundException, IOException, Exception {
		return this.cadAnimal.consultar(id);
	}
	
	public ArrayList<Object> listarAnimal() throws ClassNotFoundException, IOException, Exception {
		return this.cadAnimal.listar();
	}
	
	public void excluirAnimal(int id) throws ClassNotFoundException, IOException, Exception {
		this.cadAnimal.excluir(id);
	}
	
	public void incluirMedicoVeterinario(String nome, String sexo, String especialidade) throws ClassNotFoundException, IOException, Exception {
		MedicoVeterinario novoMedicoVeterinario = new MedicoVeterinario(0, nome, sexo, especialidade);
		this.cadMedicoVeterinario.incluir(novoMedicoVeterinario);
	}
	
	public void alterarMedicoVeterinario(MedicoVeterinario altMedicoVeterinario) throws ClassNotFoundException, IOException, Exception {
		this.cadMedicoVeterinario.alterar(altMedicoVeterinario);
	}
	
	public MedicoVeterinario consultarMedicoVeterinario(String nome) throws ClassNotFoundException, IOException, Exception {
		return this.cadMedicoVeterinario.consultar(nome);
	}
	
	public MedicoVeterinario consultarMedicoVeterinario(int id) throws ClassNotFoundException, IOException, Exception {
		return this.cadMedicoVeterinario.consultar(id);
	}
	
	public ArrayList<MedicoVeterinario> listarMedicoVeterinario() throws ClassNotFoundException, IOException, Exception {
		return this.cadMedicoVeterinario.listar();
	}
	
	public void excluirMedicoVeterinario(int id) throws ClassNotFoundException, IOException, Exception {
		this.cadMedicoVeterinario.excluir(id);
	}
	
	public void incluirAtendimento(int idMedicoVeterinario, int idAnimal, boolean urgencia) throws ClassNotFoundException, IOException, Exception {
		Atendimento novoAtendimento = new Atendimento(0, idMedicoVeterinario, idAnimal, urgencia);
		this.cadAtendimento.incluir(novoAtendimento);
	}
	
	public void alterarAtendimento(Atendimento altAtendimento) throws ClassNotFoundException, IOException, Exception {
		this.cadAtendimento.alterar(altAtendimento);
	}
	
	public ArrayList<Atendimento> listarAtendimento() throws ClassNotFoundException, IOException, Exception {
		return this.cadAtendimento.listar();
	}
	
	public void excluirAtendimento(int id) throws ClassNotFoundException, IOException, Exception {
		this.cadAtendimento.excluir(id);
	}
}
