package br.com.flexpag.postomedicoveterinario.entidade;

public class Lagarto extends Animal {
	public Lagarto() {super();}
	
	public Lagarto (int id, String nome, String especie, String raca, boolean urgencia, String necessita) {
		super(id, nome, especie, raca, urgencia, necessita);
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
	public String getEspecie() { return especie; }
	@Override
	public void setEspecie(String especie) { this.especie = especie; }
	
	@Override
	public String getRaca() { return raca; }
	@Override
	public void setRaca(String raca) { this.raca = raca; }
	
	@Override
	public boolean isUrgencia() { return urgencia; }
	@Override
	public void setUrgencia(boolean urgencia) { this.urgencia = urgencia; }
	
	@Override
	public String getNecessita() { return necessita; }
	@Override
	public void setNecessita(String necessita) { this.necessita = necessita; }
}
