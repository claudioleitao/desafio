package br.com.flexpag.postomedicoveterinario.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.AppTelas;
import br.com.flexpag.postomedicoveterinario.entidade.Animal;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.Lagarto;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.entidade.Pessoa;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorio;
import br.com.flexpag.postomedicoveterinario.repositorio.Repositorio;

public class Fachada {
	private FabricaRepositorio fabrica;
	private static Fachada instancia;
	
	private CRUD<Pessoa, Animal> cadastro;
	
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
		IRepositorio<Pessoa, Animal> repCadastro = (Repositorio<Pessoa, Animal>) fabrica.criarRepositorio();
		
		this.cadastro = new CRUD<Pessoa, Animal>(repCadastro);
	}
	
	public void addAnimal(String nome, String especie, String raca, boolean urgencia, String necessita) throws ClassNotFoundException, IOException {
		Animal animal = dadosAnimal(nome, especie, raca, urgencia, necessita);
		this.cadastro.add(null, animal);
	}
	
	public void addVeterinario(String nome, String especialidade) throws ClassNotFoundException, IOException {
		Pessoa veterinario = new MedicoVeterinario(0, nome, especialidade);
		this.cadastro.add(veterinario, null);
	}
	
	public void updateVeterinario(String nome, String especialidade) {
		Pessoa veterinario = new MedicoVeterinario(0, nome, especialidade);
		this.cadastro.update(veterinario);
	}
	
	public void removeVeterinario(String nome, String especialidade) {
		Pessoa veterinario = new MedicoVeterinario(0, nome, especialidade);
		this.cadastro.remove(veterinario);
	}
	
	public ArrayList<Pessoa> getMedico() {
		return this.cadastro.get();
	}
	
	private Animal dadosAnimal(String nome, String especie, String raca, boolean urgencia, String necessita) {
		Animal animal = null;
		
		if (especie.equalsIgnoreCase("Cachorro"))
			animal = new Cachorro(0, nome, especie, raca, urgencia, necessita);
		else if (especie.equalsIgnoreCase("Gato"))
			animal = new Gato(0, nome, especie, raca, urgencia, necessita);
		else if (especie.equalsIgnoreCase("Hamster"))
			animal = new Hamster(0, nome, especie, raca, urgencia, necessita);
		else if (especie.equalsIgnoreCase("Lagarto"))
			animal = new Lagarto(0, nome, especie, raca, urgencia, necessita);
		
		return animal;
	}
}