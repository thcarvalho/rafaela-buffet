package view.Cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controllers.TemasController;
public class CadastroTemas implements ActionListener {

	private JTextField NomeTema;
	private JTextArea DescricaoTema;
	private JFormattedTextField ValorTema;
	
	// ---------------------------------------------
	 TemasController temasct = new TemasController();
	// ---------------------------------------------

	public CadastroTemas(JTextField nome, JTextArea descricao, JFormattedTextField value) {
		NomeTema = nome;
		DescricaoTema = descricao;
		ValorTema = value;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar")) {
			adicionar(NomeTema.getText(), DescricaoTema.getText(), ValorTema.getText());
			
		}
		if (cmd.equals("Sair")) {
			// ------Salva Lista e Volta a Janela Inicial
			temasct.salvartxt();
		}

	}

	private void adicionar(String NomeTema, String DescricaoTema, String ValorTema) {

		// -------Dispondo Dados
		
         temasct.adicionar(NomeTema, DescricaoTema, ValorTema);

		// ----------Esvaziar Campos
		this.NomeTema.setText("");
		this.DescricaoTema.setText("");
		this.ValorTema.setText("");
		
	}

	

}