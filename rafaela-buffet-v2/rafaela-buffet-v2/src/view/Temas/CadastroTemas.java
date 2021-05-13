package view.Temas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import controllers.TemasController;
import models.Temas;
import services.TXTService;

public class CadastroTemas implements ActionListener {

	private JFormattedTextField NomeTema;
	private JFormattedTextField DescricaoTema;
	private JFormattedTextField ValorTema;
	
	TXTService<String> txttema = new TXTService<String>("tema.txt");	
	TemasController temascontroller = new TemasController(txttema);
	

	public CadastroTemas(JFormattedTextField nome, JFormattedTextField descricao, JFormattedTextField value) {
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
        temascontroller.createTemas(temas);
		

		// ----------Esvaziar Campos
		this.NomeTema.setText("");
		this.DescricaoTema.setText("");
		this.ValorTema.setText("");
		
	}


}