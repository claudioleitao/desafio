package br.com.flexpag.postomedicoveterinario.entidade;

public class MedicoVeterinario extends Pessoa {
	private String especialidade;
	
	public MedicoVeterinario(int id, String nome, String especialidade) {
		super(id, nome);
		this.especialidade = especialidade;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getEspecialidade() { return especialidade; }
	public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
