package br.com.flexpag.postomedicoveterinario.repositorio;

import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Pessoa;

public interface IRepositorio<P, A> {
	public void add(P pessoa, A animal);
	public void update(P pessoa);
	public void remove(P pessoa);
	public ArrayList<Pessoa> get();
}
