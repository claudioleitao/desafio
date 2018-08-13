package br.com.flexpag.postomedicoveterinario.apresentacao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.flexpag.postomedicoveterinario.entidade.Atendimento;
import br.com.flexpag.postomedicoveterinario.entidade.Cachorro;
import br.com.flexpag.postomedicoveterinario.entidade.Gato;
import br.com.flexpag.postomedicoveterinario.entidade.Hamster;
import br.com.flexpag.postomedicoveterinario.entidade.MedicoVeterinario;
import br.com.flexpag.postomedicoveterinario.negocio.Fachada;

public class TelaInserirNovoAtendimento extends JFrame {
	private Fachada fachada;
	
    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNomeAnimal;
    private JLabel lbNomeVeterinario;
    private JLabel lbUrgencia;
    private JTextField txNomeAnimal;
    private JTextField txNomeVeterinario;
    private JCheckBox cbUrgencia;
    
    public TelaInserirNovoAtendimento(DefaultTableModel md, Fachada fachada) {
        super("Incluir Atendimento");
        this.fachada = fachada;
        criaJanela();
        modelo = md;
    }
    
    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNomeAnimal = new JLabel("         Nome do animal.:   ");
        lbNomeVeterinario = new JLabel("         Nome do veterinário.:   ");
        lbUrgencia = new JLabel("         Urgência.:   ");
        txNomeAnimal = new JTextField(10);
        txNomeVeterinario = new JTextField();
        cbUrgencia = new JCheckBox();
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
        painelFundo.add(lbNomeAnimal);
        painelFundo.add(txNomeAnimal);
        painelFundo.add(lbNomeVeterinario);
        painelFundo.add(txNomeVeterinario);
        painelFundo.add(lbUrgencia);
        painelFundo.add(cbUrgencia);
        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
        btSalvar.addActionListener(new BtSalvarListener());
        btLimpar.addActionListener(new BtLimparListener());
    }
    
    private class BtSalvarListener implements ActionListener {
    	 
        public void actionPerformed(ActionEvent e) {
        	boolean urgencia = false;

			try {
				MedicoVeterinario veterinario = fachada.consultarMedicoVeterinario(txNomeVeterinario.getText());
	            Object animal = fachada.consultarAnimal(txNomeAnimal.getText());
	            
	            if (cbUrgencia.isSelected())
	            	urgencia = true;
	            
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
 
            TelaPrincipal.pesquisar(modelo);
 
            setVisible(false);
        }
    }
    
    private class BtLimparListener implements ActionListener {
    	 
        public void actionPerformed(ActionEvent e) {
            txNomeAnimal.setText("");
            txNomeVeterinario.setText("");
            cbUrgencia.setSelected(false);
        }
    }
}