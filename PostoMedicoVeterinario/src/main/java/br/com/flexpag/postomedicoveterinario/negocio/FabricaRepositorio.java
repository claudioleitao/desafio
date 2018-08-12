package br.com.flexpag.postomedicoveterinario.negocio;

import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.IRepositorioMedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAnimal;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioAtendimento;
import br.com.flexpag.postomedicoveterinario.repositorio.RepositorioMedicoVeterinario;

public class FabricaRepositorio {
	public IRepositorioAnimal criarRepositorioAnimal() {
		IRepositorioAnimal repAnimal = new RepositorioAnimal();
		return repAnimal;
	}

	public IRepositorioMedicoVeterinario criarRepositorioMedicoVeterinario() {
		IRepositorioMedicoVeterinario repMedicoVeterinario = new RepositorioMedicoVeterinario();
		return repMedicoVeterinario;
	}
	
	public IRepositorioAtendimento criarRepositorioAtendimento() {
		IRepositorioAtendimento repAtendimento = new RepositorioAtendimento();
		return repAtendimento;
	}
}
