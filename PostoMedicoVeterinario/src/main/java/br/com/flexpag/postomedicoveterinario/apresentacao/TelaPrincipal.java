package br.com.flexpag.postomedicoveterinario.apresentacao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;

public class TelaPrincipal extends JFrame {
	private static Fachada fachada;	
	
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserirMedico;
    private JButton btInserirAnimal;
    private JButton btInserirAtendimento;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();
 
    public TelaPrincipal() {
        super("Atendimento");
        this.fachada = Fachada.getInstance();
        criaJTable();
        criaJanela();
    }
 
    public void criaJanela() {
        btInserirAnimal = new JButton("Inserir Animal");
        btInserirMedico = new JButton("Inserir Veterinário");
        btInserirAtendimento = new JButton("Inserir Atendimento");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserirAnimal);
        painelBotoes.add(btInserirMedico);
        painelBotoes.add(btInserirAtendimento);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 320);
        setVisible(true);
        btInserirAnimal.addActionListener(new BtInserirAnimalListener());
        btInserirMedico.addActionListener(new BtInserirMedicoListener());
        btInserirAtendimento.addActionListener(new BtInserirAtendimentoListener());
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Nome do Animal");
        modelo.addColumn("Sexo");
        modelo.addColumn("Nome do Veterinário");
        modelo.addColumn("Especialidade");
        modelo.addColumn("Urgência");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
        pesquisar(modelo);
    }
 
    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        try {
			ArrayList<Atendimento> listaAtendimento = fachada.listarAtendimento();

			for (Atendimento atendimento : listaAtendimento) {
	        	MedicoVeterinario medicoVeterinario = fachada.consultarMedicoVeterinario(atendimento.getIdMedicoVeterinario());
	        	Object animal = fachada.consultarAnimal(atendimento.getIdAnimal());
	        	if (animal.getClass() == Cachorro.class) {
	        		Cachorro cachorro = (Cachorro) animal;
	        		modelo.addRow(new Object[]{cachorro.getNome(), cachorro.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimento.getUrgencia()});
	        	} else if (animal.getClass() == Gato.class) {
	        		Gato gato = (Gato) animal;
	        		modelo.addRow(new Object[]{gato.getNome(), gato.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimento.getUrgencia()});
	        	} else if (animal.getClass() == Hamster.class) {
	        		Hamster hamster = (Hamster) animal;
	        		modelo.addRow(new Object[]{hamster.getNome(), hamster.getSexo(), medicoVeterinario.getNome(), medicoVeterinario.getEspecialidade(), atendimento.getUrgencia()});
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
 
    private class BtInserirAtendimentoListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            TelaInserirNovoAtendimento novoAtendimento = new TelaInserirNovoAtendimento(modelo, fachada);
            novoAtendimento.setVisible(true);
        }
    }
 
    private class BtInserirMedicoListener implements ActionListener {
    	 
        public void actionPerformed(ActionEvent e) {
            TelaInserirVeterinario novoVeterinario = new TelaInserirVeterinario(modelo, fachada);
            novoVeterinario.setVisible(true);
        }
    }
    
    private class BtInserirAnimalListener implements ActionListener {
   	 
        public void actionPerformed(ActionEvent e) {
            TelaInserirAnimal novoAnimal = new TelaInserirAnimal(modelo, fachada);
            novoAnimal.setVisible(true);
        }
    }
    
    private class BtEditarListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
 //               AtualizarContato ic = new AtualizarContato(modelo, idContato, linhaSelecionada);
//                ic.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }
 
    private class BtExcluirListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
                try {
					fachada.excluirAtendimento(idContato);
					modelo.removeRow(linhaSelecionada);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }
 
    public static void main(String[] args) {
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
    }
}