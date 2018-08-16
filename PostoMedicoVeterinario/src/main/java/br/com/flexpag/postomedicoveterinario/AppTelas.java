package br.com.flexpag.postomedicoveterinario;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Animal;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.entidade.Pessoa;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;
import spark.Request;
import spark.Response;

public class AppTelas {
	private static ArrayList<Pessoa> dados;
	
	public static String incluirVeterinario(Request req, Response res, Fachada fachada) {
		String values = "";
		
		try {
			String nome = req.queryParams("txt_nomeveterinario");
			String especialidade = req.queryParams("txt_especialidade");

			fachada.addVeterinario(nome, especialidade);
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
		values = values+"<form action=\"/home\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}

	public static String incluirAnimal(Request req, Response res, Fachada fachada) {
		String values = "";
		
		try {
			String nome = req.queryParams("txt_nomeanimal");
			String especie = req.queryParams("txt_especie");
			String raca = req.queryParams("txt_raca");
			String necessita = req.queryParams("txt_necessita");
			boolean urgencia = false;
			if (req.queryParams("cb_urgencia") != null)
				urgencia = true;
			
			fachada.addAnimal(nome, especie, raca, urgencia, necessita);
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
		values = values+"<form action=\"/home\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}

	public static final String incluirCadastroAnimal() {
		return "<form action=\"/incluircadastroanimal\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Tela de inclusão de Animal:</legend>" + "    Nome do Animal:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeanimal\" name=\"txt_nomeanimal\"><br>" + "    Espécie:<br>"
				+ "    <input type=\"text\" id=\"txt_especie\" name=\"txt_especie\"><br><br>" + "    Raça:<br>"
				+ "    <input type=\"text\" id=\"txt_raca\" name=\"txt_raca\"><br>" + "  Necessita:<br>"
				+ "    <input type=\"text\" id=\"txt_necessita\" name=\"txt_necessita\"><br>"+ "  Urgência:<br>"
				+ "    <input type=\"checkbox\" id=\"cb_urgencia\" name=\"cb_urgencia\">"
				+ "    <input type=\"submit\" value=\"Incluir Animal\">" + "  </fieldset>" + "</form>";
	}

	public static final String incluirCadastroVeterinario() {
		return "<form action=\"/incluircadastroveterinario\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Tela de inclusão de Veterinário:</legend>" + "    Nome do Veterinário:<br>"
				+ "    <input type=\"text\" id=\"txt_nomeveterinario\" name=\"txt_nomeveterinario\"><br>"
				+ "    Especialidade:<br>"
				+ "    <input type=\"text\" id=\"txt_especialidade\" name=\"txt_especialidade\"><br><br>"
				+ "    <input type=\"submit\" value=\"Incluir Veterinario\">" + "  </fieldset>" + "</form>";
	}

	public static final String home() {
		String values = "<form action=\"/retornarcadastro\" method=\"POST\">" + "  <fieldset>"
				+ "    <legend>Consultar Médico Veterinário</legend>" + "    Id do Veterinário:<br>"
				+ "    <input type=\"text\" id=\"txt_idVeterinario\" name=\"txt_idVeterinario\"><br><br>"
				+ "	   <input type=\"submit\" value=\"Listar\">"
				+ "    <input type=\"submit\" value=\"Pesquisar\">" + "  </fieldset>" + "</form>";
		values = values + ""
				+ "<form action=\"/incluircadastroanimal\" method=\"GET\">"
				+ "<input type=\"submit\" value=\"Cadastro Animal\">"
				+ "</form>"
				+ "<form action=\"/incluircadastroveterinario\" method=\"GET\">"
				+ "<input type=\"submit\" value=\"Cadastro Veterinario\">"
				+ "</form>";
		
		return values;
	}
	
	public static final String retornarCadastro(Request req, Response res, boolean isListar, Fachada fachada) {
		if (req.queryParams("txt_idVeterinario") == null)
			return "<h1> Insira um id do veterinario para pesquisar</h1>";
		
		int id = Integer.parseInt(req.queryParams("txt_idVeterinario"));
		Pessoa pessoa = new MedicoVeterinario();
		dados = fachada.getMedico();
		int val = dados.size();
		
		if (dados == null)
			return "<h1> Nenhum dado foi retornado</h1>";
			
		for (Pessoa p : dados) {
			if (p.getId() == id) {
				pessoa = p;
				break;
			}
		}
		
		ArrayList<Animal> listaAnimal = ((MedicoVeterinario)pessoa).getListaAnimais();
		
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
				+ "</style>";
				values = values + "<t1>Medico:"+ pessoa.getNome() +"</t1>"
				+ ""
				+ "<table style=\"width:100%\">"
				+ "<tr>"
				+ "    <th>Id</th>"
				+ "    <th>Nome Animal</th>"
				+ "    <th>Urgência</th>"
				+ "</tr>";
		if (isListar) {
			for (Animal animal : listaAnimal) {
				values = values
						+ "<tr>"
						+ "		<td>"+animal.getId()+"</td>"
						+ "     <td>"+animal.getNome()+"</td>"
						+ "     <td>"+animal.isUrgencia()+"</td>"
						+ "</tr>";
			}
		} else {
			Animal animal = listaAnimal.get(0);
			values = values
			+ "<tr>"
			+ "		<td>"+animal.getId()+"</td>"
			+ "     <td>"+animal.getNome()+"</td>"
			+ "     <td>"+animal.isUrgencia()+"</td>"
			+ "</tr>";
		}
		
		values = values+"</table>";
		
		values = values+"<form action=\"/home\" method=\"GET\">";
		values = values+"<input type=\"submit\" value=\"Voltar\">";
		values = values+"</form>";
		
		return values;
	}
}
