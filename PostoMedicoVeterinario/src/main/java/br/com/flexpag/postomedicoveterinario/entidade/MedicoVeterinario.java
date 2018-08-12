package br.com.flexpag.postomedicoveterinario.entidade;

public class MedicoVeterinario extends Pessoa {
	private String especialidade;
	
	public MedicoVeterinario(int id, String nome, String sexo, String especialidade) {
		super(id, nome, sexo);
		this.especialidade = especialidade;
	}
	
	@Override
	public int getId() { return id; }
	@Override
	public void setId(int id) { this.id = id; }
	
	@Override
	public String getNome() { return nome; }
	@Override
	public void setNome(String nome) { this.nome = nome; }

	@Override
	public String getSexo() { return sexo; }
	@Override
	public void setSexo(String sexo) { this.sexo = sexo; }
	
	public String getEspecialidade() { return especialidade; }
	public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
