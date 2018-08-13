package br.com.flexpag.postomedicoveterinario;

import static spark.Spark.*;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.utils.IOUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static Object[][] dados = null;

	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();

		int i = 0;

		try {
			ArrayList<Atendimento> lista = fachada.listarAtendimento();
			dados = new Object[lista.size()][5];
			for (Atendimento atendimento : lista) {
				MedicoVeterinario vet = fachada.consultarMedicoVeterinario(atendimento.getIdMedicoVeterinario());
				Object animal = fachada.consultarAnimal(atendimento.getIdAnimal());

				if (animal.getClass() == Cachorro.class) {
					Cachorro cachorro = (Cachorro) animal;
					dados[i][0] = cachorro.getNome();
					dados[i][1] = cachorro.getSexo();
					dados[i][2] = vet.getNome();
					dados[i][3] = vet.getEspecialidade();
					dados[i][4] = atendimento.getUrgencia();
				} else if (animal.getClass() == Gato.class) {
					Gato gato = (Gato) animal;
					dados[i][0] = gato.getNome();
					dados[i][1] = gato.getSexo();
					dados[i][2] = vet.getNome();
					dados[i][3] = vet.getEspecialidade();
					dados[i][4] = atendimento.getUrgencia();
				} else if (animal.getClass() == Hamster.class) {
					Hamster hamster = (Hamster) animal;
					dados[i][0] = hamster.getNome();
					dados[i][1] = hamster.getSexo();
					dados[i][2] = vet.getNome();
					dados[i][3] = vet.getEspecialidade();
					dados[i][4] = atendimento.getUrgencia();
				}

				i++;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		get("/retornarcadastro", (req, res) -> retornarCadastro());
		get("/incluircadastroanimal", (req, res) -> incluirCadastroAnimal());
		get("/incluircadastroatendimento", (req, res) -> incluirCadastroAtendimento());
		get("/incluircadastroveterinario", (req, res) -> incluirCadastroVeterinario());
		
		post("/incluircadastroatendimento", (req, res) -> {
			return incluirAtendimento(req, res, fachada);
		});
		post("/incluircadastroveterinario", (req, res) -> {
			return incluirVeterinario(req, res, fachada);
		});
		post("/incluircadastroanimal", (req, res) -> {
			return incluirAnimal(req, res, fachada);
		});
	}

	public static String incluirAtendimento(Request req, Response res, Fachada fachada) {
		String values = "";
		
		try {
			String nomeAnimal = req.queryParams("txt_nomeanimal");
			String nomeVeterinario = req.queryParams("txt_nomeveterinario");
			boolean urgencia = Boolean.parseBoolean(req.queryParams("cb_urgencia"));
			Object animal = fachada.consultarAnimal(nomeAnimal);
			MedicoVeterinario veterinario = fachada.consultarMedicoVeterinario(nomeVeterinario);

			if (animal.getClass() == Cachorro.class) {
				Cachorro cachorro = (Cachorro) animal;
				fachada.incluirAtendimento(veterinario.getId(), cachorro.getId(), urgencia);
			} else if (animal.getClass() == Gato.class) {
				Gato gato = (Gato) animal;
				fachada.incluirAtendimento(veterinario.getId(), gato.getId(), urgencia);
			} else if (animal.getClass() == Hamster.class) {
				Hamster hamster = (Hamster) animal;
				fachada.incluirAtendimento(veterinario.getId(), hamster.getId(), urgencia);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		values = values+"Inclusão do Veterinário com sucesso";
		values = values+"<form action=\"/retornarcadastro\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}

	public static String incluirVeterinario(Request req, Response res, Fachada fachada) {
		String values = "";
		
		try {
			String nome = req.queryParams("txt_nomeveterinario");
			String sexo = req.queryParams("txt_sexo");
			String especialidade = req.queryParams("txt_especialidade");

			fachada.incluirMedicoVeterinario(nome, sexo, especialidade);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		values = values+"Inclusão do Veterinário com sucesso";
		values = values+"<form action=\"/retornarcadastro\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}

	public static String incluirAnimal(Request req, Response res, Fachada fachada) {
		String values = "";
		
		try {
			String nome = req.queryParams("txt_nomeanimal");
			String sexo = req.queryParams("txt_sexo");
			String especie = req.queryParams("txt_especie");
			String raca = req.queryParams("txt_raca");

			fachada.incluirAnimal(nome, sexo, especie, raca);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		values = values+"Inclusão do animal com sucesso";
		values = values+"<form action=\"/retornarcadastro\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}

	public static final String incluirCadastroAnimal() {
		return "<form action=\"/incluircadastroanimal\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Tela de inclusão de Animal:</legend>" + "    Nome do Animal:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeanimal\" name=\"txt_nomeanimal\"><br>" + "    Sexo:<br>"
				+ "    <input type=\"text\" id=\"txt_sexo\" name=\"txt_sexo\"><br><br>" + "    Espécie:<br>"
				+ "    <input type=\"text\" id=\"txt_especie\" name=\"txt_especie\"><br><br>" + "    Raça:<br>"
				+ "    <input type=\"text\" id=\"txt_raca\" name=\"txt_raca\"><br><br>"
				+ "    <input type=\"submit\" value=\"Submit\">" + "  </fieldset>" + "</form>";
	}

	public static final String incluirCadastroAtendimento() {
		return "<form action=\"/incluircadastroatendimento\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Tela de inclusão de Atendimento:</legend>" + "    Nome do Animal:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeanimal\" name=\"txt_nomeanimal\"><br>"
				+ "    Nome do Veterinário:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeveterinario\" name=\"txt_nomeveterinario\"><br><br>"
				+ "    Urgência:<br>" + "    <input type=\"checkbox\" id=\"cb_urgencia\" name=\"cb_urgencia\"><br><br>"
				+ "    <input type=\"submit\" value=\"Submit\">" + "  </fieldset>" + "</form>";
	}

	public static final String incluirCadastroVeterinario() {
		return "<form action=\"/incluircadastroveterinario\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Tela de inclusão de Veterinário:</legend>" + "    Nome do Veterinário:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeveterinario\" name=\"txt_nomeveterinario\"><br>"
				+ "    Sexo:<br>" + "    <input type=\"text\" id=\"txt_sexo\" name=\"txt_sexo\"><br><br>"
				+ "    Especialidade:<br>"
				+ "    <input type=\"text\" id=\"txt_especialidade\" name=\"txt_especialidade\"><br><br>"
				+ "    <input type=\"submit\" value=\"Submit\">" + "  </fieldset>" + "</form>";
	}

	public static final String retornarCadastro() {
		String values = "<style>"
				+ "table {"
				+ "    font-family: arial, sans-serif;"
				+ "    border-collapse: collapse;"
				+ "    width: 100%;"
				+ "}"
				+ ""
				+ "td, th {"
				+ "    border: 1px solid #dddddd;"
				+ "    text-align: left;"
				+ "    padding: 8px;"
				+ "}"
				+ ""
				+ "tr:nth-child(even) {"
				+ "    background-color: #dddddd;"
				+ "}"
				+ "</style>"
				+ ""
				+ "<table style=\"width:100%\">"
				+ "<tr>"
				+ "    <th>Nome do Animal</th>"
				+ "    <th>Sexo do Animal</th>"
				+ "    <th>Nome do Veterinário</th>"
				+ "    <th>Especialidade</th>"
				+ "    <th>Urgência</th>"
				+ "</tr>";
		for (int i = 0; i < dados.length; i++) {
			values = values
				+ "<tr>"
				+ "		<td>"+dados[i][0]+"</td>"
				+ "     <td>"+dados[i][1]+"</td>"
				+ "     <td>"+dados[i][2]+"</td>"
				+ "     <td>"+dados[i][3]+"</td>"
				+ "     <td>"+dados[i][4]+"</td>"
				+ "</tr>";
		}
		
		values = values+"</table>";
		
		values = values+"<form action=\"/incluircadastroanimal\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Cadastro Animal\">";
		values = values+"</form>";
		values = values+"<form action=\"/incluircadastroveterinario\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Cadastro Veterinario\">";
		values = values+"</form>";
		values = values+"<form action=\"/incluircadastroatendimento\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Incluir Atendimento\">";
		values = values+"</form>";
		
		return values;
	}
}
