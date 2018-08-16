package br.com.flexpag.postomedicoveterinario.entidade;

import java.util.ArrayList;

public class MedicoVeterinario extends Pessoa {
	private String especialidade;
	private ArrayList<Animal> listaAnimais;
	
	public MedicoVeterinario() {super();}
	
	public MedicoVeterinario(int id, String nome, String especialidade) {
		super(id, nome);
		this.especialidade = especialidade;
		this.listaAnimais = new ArrayList<Animal>();
	}
	
	@Override
	public int getId() { return id; }
	@Override
	public void setId(int id) { this.id = id; }
	
	@Override
	public String getNome() { return nome; }
	@Override
	public void setNome(String nome) { this.nome = nome; }

	public String getEspecialidade() { return especialidade; }
	public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

	public ArrayList<Animal> getListaAnimais() { return listaAnimais; }

	public void setListaAnimais(Animal animal) {
		this.listaAnimais = this.ordenar(animal);
	}
	
	private ArrayList<Animal> ordenar(Animal animal) {
		ArrayList<Animal> bkpLista = null;
		int id = 0;
		
		if (this.listaAnimais.size() == 0)
			id++;
		else
			id = this.listaAnimais.size() + 1;
		
		animal.setId(id);
		
		if (animal.isUrgencia()) {
			bkpLista = new ArrayList<Animal>();
			bkpLista.add(animal);
			
			for (Animal temp : this.listaAnimais)
				bkpLista.add(temp);			
		} else {
			bkpLista = this.listaAnimais;
			bkpLista.add(animal);
		}
		
		return bkpLista;
	}
}
