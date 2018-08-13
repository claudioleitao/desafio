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

public class TelaInserirAnimal extends JFrame {
	private Fachada fachada;
	
    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbSexo;
    private JLabel lbEspecie;
    private JLabel lbRaca;
    private JTextField txNome;
    private JTextField txSexo;
    private JTextField txEspecie;
    private JTextField txRaca;

    public TelaInserirAnimal(DefaultTableModel md, Fachada fachada) {
        super("Cadastro Animal");
        this.fachada = fachada;
        criaJanela();
        modelo = md;
    }
    
    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("               Nome.:   ");
        lbSexo = new JLabel("               Sexo.:   ");
        lbEspecie = new JLabel("         Especie.:   ");
        lbRaca = new JLabel("         Raca.:   ");
        txNome = new JTextField(10);
        txSexo = new JTextField();
        txEspecie = new JTextField();
        txRaca = new JTextField();
 
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbSexo);
        painelFundo.add(txSexo);
        painelFundo.add(lbEspecie);
        painelFundo.add(txEspecie);
        painelFundo.add(lbRaca);
        painelFundo.add(txRaca);
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
        		if (txEspecie.getText().equalsIgnoreCase("Cachorro"))
        			fachada.incluirAnimal(txNome.getText(), txSexo.getText(), "Cachorro", txRaca.getText());
        		else if (txEspecie.getText().equalsIgnoreCase("Gato"))
        			fachada.incluirAnimal(txNome.getText(), txSexo.getText(), "Gato", txRaca.getText());
        		else if (txEspecie.getText().equalsIgnoreCase("Hamster"))
        			fachada.incluirAnimal(txNome.getText(), txSexo.getText(), "Hamster", txRaca.getText());
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
            txEspecie.setText("");
            txRaca.setText("");
        }
    }
}