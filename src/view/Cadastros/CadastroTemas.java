package view.Cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Temas;
import list.List;

public class CadastroTemas implements ActionListener {

	private JTextField NomeTema;
	private JTextArea DescricaoTema;
	private JFormattedTextField ValorTema;
	// ---------------------------------------------
	List<String> list = new List<String>();
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
			// ------Back Janela Inicial
		}

	}

	private void adicionar(String NomeTema, String DescricaoTema, String ValorTema) {

		// -------Dispondo dados dos Temas
		int Value = Integer.parseInt(ValorTema);
		Temas tema = new Temas(NomeTema, DescricaoTema, Value);
		tema.setNome(NomeTema);
		tema.setDescricao(DescricaoTema);
		tema.setValue(Value);

		// -- Temporario - Visualizar criar e visualizar Lista:
		list.add(tema.toString());
		System.out.println(list.toString());

		// ----------Esvaziar Campos
		this.NomeTema.setText(" ");
		this.DescricaoTema.setText(" ");
		this.ValorTema.setText(" ");

	}

	

}