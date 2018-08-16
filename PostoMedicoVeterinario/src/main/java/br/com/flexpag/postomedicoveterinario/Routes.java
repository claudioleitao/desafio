package br.com.flexpag.postomedicoveterinario;

import static spark.Spark.get;
import static spark.Spark.post;

import br.com.flexpag.postomedicoveterinario.negocio.Fachada;

/**
 * Hello world!
 *
 */
public class Routes {
	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		
		get("/home", (req, res) -> AppTelas.home());
		get("/incluircadastroanimal", (req, res) -> AppTelas.incluirCadastroAnimal());
		get("/incluircadastroveterinario", (req, res) -> AppTelas.incluirCadastroVeterinario());
		get("/retornarcadastro", (req, res) -> AppTelas.retornarCadastro(req, res, false, fachada));
		
		
		post("/retornarcadastro", (req, res) -> { return AppTelas.retornarCadastro(req, res, false, fachada); });
		post("/incluircadastroveterinario", (req, res) -> { return AppTelas.incluirVeterinario(req, res, fachada); });
		post("/incluircadastroanimal", (req, res) -> { return AppTelas.incluirAnimal(req, res, fachada); });
		
	}
	
}
