package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorio;
import br.com.flexpag.postomedicoveterinario.repositorio.Repositorio;

public class FabricaRepositorio<P, A> {	
	public IRepositorio<P, A> criarRepositorio() {
		IRepositorio<P, A> repositorio = new Repositorio<P, A>();
		return repositorio;
	}
}
