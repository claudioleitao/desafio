package br.com.flexpag.postomedicoveterinario.apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;

public class TelaPrincipal extends Tela {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8694354957160335206L;
	private Fachada fachada;	
	
	private Tela tela;
	
	private JTable tabelaAtendimento;
	private DefaultTableModel modelo;
	
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	
	JLabel lblNewLabel = new JLabel("");
	
	public TelaPrincipal() {
		super();
		
		fachada = Fachada.getInstance();
		
		this.setExtendedState(MAXIMIZED_BOTH);
		
		//this.usuarioLogado = logado;
		//this.crudFuncionario = crudFuncionario;
		
		this.setTitle("Sistema de Posto Médico Veterinário - Principal");
		//this.lblNewLabel.setIcon(new ImageIcon(".\\imagens\\wallpaper\\commscope_hospitalar.jpg"));
		
		this.setContentPane(lblNewLabel);
		
		this.formulario();
		
		this.setVisible(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	protected void formulario() {
		this.setLayout(null);
		this.menuBar = this.menuBar();
		
		this.setJMenuBar(this.menuBar);
		this.tabela();
	}
	
	private void tabela() {
		this.modelo = new DefaultTableModel();
		this.tabelaAtendimento = new JTable(modelo);
		this.modelo.addColumn("Nome do Animal");
		this.modelo.addColumn("Sexo");
		this.modelo.addColumn("Nome do Veterinário");
		this.modelo.addColumn("Especialidade");
		this.modelo.addColumn("Urgência");
		this.modelo.addColumn("Atendido");
		this.modelo.addColumn("Desmarcar Consulta");
		
		try {
			ArrayList<Atendimento> atendimento = fachada.listarAtendimento();
			
			for (Atendimento atendimentoAtual : atendimento) {
				MedicoVeterinario medicoVeterinario = fachada.consultarMedicoVeterinario(atendimentoAtual.getIdMedicoVeterinario());
				Object animal = fachada.consultarAnimal(atendimentoAtual.getIdAnimal());
				
				if (animal.getClass().toString().equalsIgnoreCase("Cachorro")) {
					Cachorro cachorro = (Cachorro) animal;
					this.modelo.addRow(new Object[]{cachorro.getNome(), cachorro.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimentoAtual.getUrgencia()});
				} else if (animal.getClass().toString().equalsIgnoreCase("Gato")) {
					Gato gato = (Gato) animal;
					this.modelo.addRow(new Object[]{gato.getNome(), gato.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimentoAtual.getUrgencia()});
				} else if (animal.getClass().toString().equalsIgnoreCase("Hamster")) {
					Hamster hamister = (Hamster) animal;
					this.modelo.addRow(new Object[]{hamister.getNome(), hamister.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimentoAtual.getUrgencia()});
				}
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
	}
	
	private JMenuBar menuBar() {
		this.menuBar = new JMenuBar();
		
		this.menuArquivo = this.menuArquivo();
		
		this.menuBar.add(this.menuArquivo);
		
		return this.menuBar;
	}
	
	private JMenu menuArquivo() {
		JMenu menu = new JMenu("Arquivo");
		JMenuItem menuItemSair = this.menuItemSair();
		
		menu.add(menuItemSair);
		
		return menu;
	}
		
	private JMenuItem menuItemSair() {
		JMenuItem menuItem = new JMenuItem("Sair");
		
		menuItem.addActionListener(
				new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						actionSair();
					}
				});
		
		return menuItem;
	}
		
	private void actionCadastroMedicoVeterinario() {
		//this.tela = new TelaCadastroMedicoVeterinario();
		this.tela.setVisible(true);
	}
	private void actionCadastroPaciente() {
		//this.tela = new TelaCadastroAnimal();
		this.tela.setVisible(true);		
	}
	private void actionSair() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}