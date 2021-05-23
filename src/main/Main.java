package main;
import view.Client.InterfaceCadastroCliente;
import view.Client.EditClientes;

import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.Temas.EditTemas;
import view.Agendamentos.InterfaceAgendamentos;
import view.Temas.InterfaceCadastroTemas;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//  InterfaceCadastroCliente cadastrarclientes = new InterfaceCadastroCliente();
    //  cadastrarclientes.Start();
		
	//  EditClientes clientes = new EditClientes();
	 // clientes.start();
		
	    InterfaceAgendamentos agendamentos = new InterfaceAgendamentos();
	    agendamentos.Start();
	    	
	//   InterfaceCadastroTemas cadastrartemas = new InterfaceCadastroTemas();
	 //  cadastrartemas.Start();
	    
	//   EditTemas temas = new EditTemas();
	 //  temas.start();
		    
	    
	}
}
