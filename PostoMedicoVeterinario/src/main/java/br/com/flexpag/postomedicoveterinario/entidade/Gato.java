package br.com.flexpag.postomedicoveterinario.entidade;

public class Gato extends Animal {
	private String raca;
	
	public Gato(int id, String nome, String raca) {
		super(id, nome);
		this.raca = raca;
	}
	
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getRaca() { return raca; }
	public void setRaca(String raca) { this.raca = raca; }
}
