package view.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import controllers.ClientController;
import services.TXTService;
import models.Client;


public class CadastroCliente implements ActionListener {

	private JFormattedTextField Nome;
	private JFormattedTextField CPF;
	private JFormattedTextField Email;
	private JFormattedTextField Tel;
	
	TXTService<Client> txtclient = new TXTService<>("client.txt");
	ClientController clientcontroller = new ClientController(txtclient);
	
	
	public CadastroCliente(JFormattedTextField nome, JFormattedTextField cpf, JFormattedTextField email,
			JFormattedTextField tel) {
		Nome = nome;
		CPF = cpf;
		Email = email;
		Tel = tel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar")) {
			adicionar(CPF.getText(), Nome.getText(), Tel.getText(), Email.getText());
		}
	}

	public void adicionar(String CPF, String Nome, String Tel, String Email) {

		// -------Dispondo dados do cliente
		
		Client client = new Client(CPF, Nome, Email, Tel);
		client.setCPF(CPF);
		client.setName(Nome);
		client.setEmail(Email);
		client.setTel(Tel);
        clientcontroller.create(client);

		// ----------Esvaziar Campos
        
		this.Nome.setText("");
		this.CPF.setText("");
		this.Email.setText("");
		this.Tel.setText("");

	}

}
