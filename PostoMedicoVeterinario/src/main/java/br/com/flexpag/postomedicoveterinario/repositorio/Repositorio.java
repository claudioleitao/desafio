package br.com.flexpag.postomedicoveterinario.repositorio;

import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Animal;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.Lagarto;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.entidade.Pessoa;

public class Repositorio<P, A> implements IRepositorio<P, A> {
	private ArrayList<Pessoa> dados;
	
	public Repositorio() {
		this.dados = new ArrayList<Pessoa>();
	}

	public void add(P pessoa, A animal) {
		if (pessoa != null)
			this.addPessoa((Pessoa)pessoa);
		else if (animal != null)
			this.addAnimal((Animal)animal);
	}
	
	public void update(P pessoa) {
		if (pessoa != null)
			this.updatePessoa((Pessoa)pessoa);
	}
	
	public void remove(P pessoa) {
		this.dados.remove((MedicoVeterinario)pessoa);
	}
	
	public ArrayList<Pessoa> get() {		
		return dados;
	}

	private void addPessoa(Pessoa pessoa) {
		pessoa.setId(dados.size()+1);
		dados.add(pessoa);
	}
	
	private void addAnimal(Animal animal) {
		if (animal.getClass() == Cachorro.class)
			this.dadosAnimais((Cachorro)animal);
		else if (animal.getClass() == Gato.class)
			this.dadosAnimais((Gato)animal);
		else if (animal.getClass() == Hamster.class)
			this.dadosAnimais((Hamster)animal);
		else if (animal.getClass() == Lagarto.class)
			this.dadosAnimais((Lagarto)animal);
	}
	
	private void dadosAnimais(Animal animal) {
		for (Pessoa dado : this.dados) {
			if (((MedicoVeterinario)dado).getEspecialidade().equalsIgnoreCase(animal.getNecessita()))
				((MedicoVeterinario)dado).setListaAnimais(animal);
		}
	}
	
	private void updatePessoa(Pessoa pessoa) {
		if (pessoa.getClass() == MedicoVeterinario.class)
			for (Pessoa medico : this.dados) {
				if (((MedicoVeterinario)medico).getId() == ((MedicoVeterinario)pessoa).getId()) {
					this.dados.set(this.dados.indexOf(medico), medico);
				}
			}
	}
}
