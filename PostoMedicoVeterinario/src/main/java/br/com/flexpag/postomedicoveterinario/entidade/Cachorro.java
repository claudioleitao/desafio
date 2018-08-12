package br.com.flexpag.postomedicoveterinario.entidade;

public class Cachorro extends Animal {
	private String raca;
	
	public Cachorro() {super();}
	
	public Cachorro (int id, String nome, String sexo, String raca) {
		super(id, nome, sexo);
		this.raca = raca;
	}
	
	@Override
	public int getId() { return this.id; }
	@Override
	public void setId(int id) { this.id = id; }
	
	@Override
	public String getNome() { return this.nome; }
	@Override
	public void setNome(String nome) { this.nome = nome; }

	@Override
	public String getSexo() { return sexo; }
	@Override
	public void setSexo(String sexo) { this.sexo = sexo; }
	
	public String getRaca() { return raca; }
	public void setRaca(String raca) { this.raca = raca; }
}
