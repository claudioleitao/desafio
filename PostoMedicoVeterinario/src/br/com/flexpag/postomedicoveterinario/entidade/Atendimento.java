package br.com.flexpag.postomedicoveterinario.entidade;

public class Atendimento {
	private boolean urgencia;
	private String especialidade;
	
	public Atendimento(boolean urgencia, String especialidade) {
		this.urgencia = urgencia;
		this.especialidade = especialidade;
	}
	
	public boolean getUrgencia() { return urgencia; }
	public void setUrgencia(boolean urgencia) { this.urgencia = urgencia; }
	
	public String getEspecialidade() { return especialidade; }
	public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
