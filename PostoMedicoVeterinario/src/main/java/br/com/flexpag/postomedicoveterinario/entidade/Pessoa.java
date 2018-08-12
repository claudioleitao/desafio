package br.com.flexpag.postomedicoveterinario.entidade;

public abstract class Pessoa {
	protected int id;
	protected String nome;
	protected String sexo;
	
	public Pessoa(int id, String nome, String sexo) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
	}

	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getNome();
	public abstract void setNome(String nome);
	public abstract String getSexo();
	public abstract void setSexo(String sexo);
}
