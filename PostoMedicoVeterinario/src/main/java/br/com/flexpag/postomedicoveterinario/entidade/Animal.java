package br.com.flexpag.postomedicoveterinario.entidade;

public abstract class Animal {
	protected int id;
	protected String nome;
	
	public Animal(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getNome();
	public abstract void setNome(String nome);
}
