package br.com.flexpag.postomedicoveterinario;

import java.io.IOException;
import java.util.ArrayList;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        TesteVeterinario();
        TesteAnimal();
        TesteAtendimento();
    }
    
    public void TesteVeterinario() {
        Fachada fachada = Fachada.getInstance();
        try {
			fachada.incluirMedicoVeterinario("Teste", "teste", "teste");
			MedicoVeterinario m = new MedicoVeterinario(0, "Teste", "Teste", "Teste");
			fachada.alterarMedicoVeterinario(m);
			m = fachada.consultarMedicoVeterinario("Teste");
			fachada.excluirMedicoVeterinario(1);
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
    }
    
    public void TesteAnimal() {
        Fachada fachada = Fachada.getInstance();
        try {
			fachada.incluirAnimal("Teste", "teste", "teste","Animal");
			fachada.alterarAnimal("Teste", "teste", "Cachorro","Animal");
			Object c = fachada.consultarMedicoVeterinario("Teste");
			fachada.excluirMedicoVeterinario(1);
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
    }
    
    public void TesteAtendimento() {
        Fachada fachada = Fachada.getInstance();
        try {
			fachada.incluirAtendimento(1, 1,true);
			Atendimento a = new Atendimento(1, 1, 1, true);
			fachada.alterarAtendimento(a);
			ArrayList<Atendimento> la = fachada.listarAtendimento();
			fachada.excluirAtendimento(1);
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
    }
}
