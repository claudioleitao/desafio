package br.com.flexpag.postomedicoveterinario.apresentacao;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class Tela extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1408285249500805100L;

	public Tela(){}
	
	protected abstract void formulario();
	
	protected JButton buttons(String titulo, int x, int y, int width, int height) {
		JButton btn = new JButton(titulo);
		btn.setBounds(x, y, width, height);
		
		return btn;
	}
	
	protected JButton buttons(String titulo, String imagem, int x, int y, int width, int height) {
		Icon icoImg = new ImageIcon(imagem);
		JButton btn = new JButton(titulo, icoImg);
		btn.setBounds(x, y, width, height);
		
		return btn;
	}
	
	protected JLabel texto(String texto, int x, int y, int width, int height) {
		JLabel text = new JLabel(texto);
		text.setBounds(x, y, width, height);
		return text;
	}
	
	protected JTextField campo(int x, int y, int width, int height) {
		JTextField txtField = new JTextField();
		txtField.setBounds(x, y, width, height);
		return txtField;
	}
	
	protected JTextArea campoArea(int x, int y, int width, int height) {
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(x, y, width, height);
		return txtArea;
	}
	
	protected JPasswordField campoSenha(int x, int y, int width, int height) {
		JPasswordField txtField = new JPasswordField();
		txtField.setBounds(x, y, width, height);
		return txtField;
	}
}
