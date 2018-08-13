package br.com.flexpag.postomedicoveterinario.apresentacao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.flexpag.postomedicoveterinario.negocio.Fachada;

public class TelaInserirVeterinario extends JFrame {
	private Fachada fachada;
	
    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbSexo;
    private JLabel lbEspecialidade;
    private JTextField txNome;
    private JTextField txSexo;
    private JTextField txEspecialidade;

    public TelaInserirVeterinario(DefaultTableModel md, Fachada fachada) {
        super("Cadastro Veterinario");
        this.fachada = fachada;
        criaJanela();
        modelo = md;
    }
    
    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("               Nome.:   ");
        lbSexo = new JLabel("               Sexo.:   ");
        lbEspecialidade = new JLabel("         Especialidade.:   ");
        txNome = new JTextField(10);
        txSexo = new JTextField();
        txEspecialidade = new JTextField();
 
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbSexo);
        painelFundo.add(txSexo);
        painelFundo.add(lbEspecialidade);
        painelFundo.add(txEspecialidade);
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
        	try {
        		fachada.incluirMedicoVeterinario(txNome.getText(), txSexo.getText(), txEspecialidade.getText());
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
            
            setVisible(false);
        }
    }
    
    private class BtLimparListener implements ActionListener {
    	 
        public void actionPerformed(ActionEvent e) {
            txNome.setText("");
            txSexo.setText("");
            txEspecialidade.setText("");
        }
    }
}
