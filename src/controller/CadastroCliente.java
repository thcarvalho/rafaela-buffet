package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

import model.Client;
import util.ListCadastroCliente;
public class CadastroCliente implements ActionListener {
	
	private JFormattedTextField Nome;
	private JFormattedTextField CPF;
	private JFormattedTextField Email;
	private JFormattedTextField Tel;
    ListCadastroCliente<String> Listacadastro = new ListCadastroCliente<String>();
    Client cadastrar = new Client();
    
	

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
		if (cmd.equals("Cadastrar")){
			adicionar(CPF.getText(),Nome.getText(),Tel.getText(),Email.getText());
		}
		if(cmd.equals("Sair")) {
			//------Back Janela Inicial		
		}	
	}


	 public void adicionar(String CPF, String Nome, String Tel, String Email) {
		 
	      boolean retorno = Listacadastro.consultaCpf(CPF,Listacadastro.toString());   
		  if(retorno) {
			 cadastrar.setCPF(CPF);
			 cadastrar.setName(Nome);
			 cadastrar.setTel(Tel);
			 cadastrar.setEmail(Email);
			 //-----Gerando Lista
	          String dados = Listacadastro.dadoscliente(cadastrar.getCPF(), cadastrar.getName(), 
	          cadastrar.getEmail(), cadastrar.getTel());
	          Listacadastro.lista(dados);	
		 }

		  
		//----------Esvaziar Campos
		this.Nome.setText(" ");
	    this.CPF.setText(" ");
	    this.Email.setText(" ");
	    this.Tel.setText(" ");
	}

}
