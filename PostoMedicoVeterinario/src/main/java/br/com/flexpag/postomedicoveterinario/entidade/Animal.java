package br.com.flexpag.postomedicoveterinario.entidade;

public abstract class Animal {
	protected int id;
	protected String nome;
	protected String especie;
	protected String raca;
	protected boolean urgencia;
	protected String necessita;
	
	public Animal() {}
	
	public Animal(int id, String nome, String especie, String raca, boolean urgencia, String necessita) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.urgencia = urgencia;
		this.necessita = necessita;
	}
	
	public int getId() { return 0; }
	public void setId(int id) { this.id = 0; }
	public String getNome() { return ""; }
	public void setNome(String nome) { this.nome = ""; }
	public String getEspecie() { return ""; }
	public void setEspecie(String especie) { this.especie = ""; }
	public String getRaca() { return "";}
	public void setRaca(String raca) { this.raca = ""; }
	public boolean isUrgencia() { return false; }
	public void setUrgencia(boolean urgencia) { this.urgencia = false; }
	public String getNecessita() { return necessita; }
	public void setNecessita(String necessita) { this.necessita = necessita; }
}
