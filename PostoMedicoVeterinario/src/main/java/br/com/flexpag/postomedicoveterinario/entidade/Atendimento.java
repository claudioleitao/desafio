package br.com.flexpag.postomedicoveterinario.entidade;

public class Atendimento {
	private int id;
	private int idMedicoVeterinario;
	private int idAnimal;
	private boolean urgencia;
	
	public Atendimento() { }
	
	public Atendimento(int id, int idMedicoVeterinario, int idAnimal, boolean urgencia) {
		this.id = id;
		this.idMedicoVeterinario = idMedicoVeterinario;
		this.idAnimal = idAnimal;
		this.urgencia = urgencia;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public int getIdMedicoVeterinario() { return idMedicoVeterinario; }
	public void setIdMedicoVeterinario(int idMedicoVeterinario) { this.idMedicoVeterinario = idMedicoVeterinario; }

	public int getIdAnimal() { return idAnimal; }
	public void setIdAnimal(int idAnimal) { this.idAnimal = idAnimal; }

	public boolean getUrgencia() { return urgencia; }
	public void setUrgencia(boolean urgencia) { this.urgencia = urgencia; }
}
