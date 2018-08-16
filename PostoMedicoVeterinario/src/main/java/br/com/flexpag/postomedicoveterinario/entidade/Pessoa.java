package br.com.flexpag.postomedicoveterinario.entidade;

public abstract class Pessoa {
	protected int id;
	protected String nome;
	
	public Pessoa () {}
	
	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() { return 0; }
	public void setId(int id) { this.id = 0; }
	public String getNome() { return ""; }
	public void setNome(String nome) { this.nome = ""; }
}
