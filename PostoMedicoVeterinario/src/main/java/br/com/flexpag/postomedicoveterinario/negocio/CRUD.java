package br.com.flexpag.postomedicoveterinario.negocio;

import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Animal;
import br.com.flexpag.postomedicoveterinario.entidade.Pessoa;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorio;

public class CRUD<P, A> {
	private IRepositorio<P, A> objRepositorio;
	
	public CRUD(IRepositorio<P, A> objRepositorio){
		this.objRepositorio = objRepositorio;
	}
	
	public void add(P pessoa, A animal) {
		this.objRepositorio.add(pessoa, animal);
	}
	
	public void update(P pessoa) {
		this.objRepositorio.update(pessoa);
	}
	
	public void remove(P pessoa) {
		this.objRepositorio.remove(pessoa);
	}
	
	public ArrayList<Pessoa> get() {
		return this.objRepositorio.get();
	}
}
