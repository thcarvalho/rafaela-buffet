package view.Temas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.TemasController;
import models.Temas;
import services.TXTService;

public class CadastroTemas implements ActionListener {

	private JTextField NomeTema;
	private JTextArea DescricaoTema;
	private JFormattedTextField ValorTema;
	TXTService<Temas> txttemas = new TXTService<>("temas.txt");
	TemasController temascontroller = new TemasController(txttemas);

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
			// ------Back tela Principal
			
			
		}

	}

	private void adicionar(String NomeTema, String DescricaoTema, String ValorTema) {

		// -------Dispondo Dados
		
		Temas temas = new Temas(NomeTema, DescricaoTema, ValorTema);
		temas.setNome(NomeTema);
		temas.setDescricao(DescricaoTema);
		temas.setValue(ValorTema);
		temascontroller.add(temas);

		// ----------Esvaziar Campos
		this.NomeTema.setText("");
		this.DescricaoTema.setText("");
		this.ValorTema.setText("");
		
	}


}