package main;
import view.Main.*;
import view.Client.InterfaceCadastroCliente;
import view.Client.EditClientes;
import java.awt.Window.Type;
import java.util.Calendar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Temas.EditTemas;
import view.Agendamentos.InterfaceAgendamentos;
import view.Agendamentos.InterfaceAgendar;
import view.Temas.InterfaceCadastroTemas;
import view.Temas.EditTemas;


public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// InterfaceCadastroCliente cadastrarclientes = new InterfaceCadastroCliente();
    // cadastrarclientes.Start();
		
	//  EditClientes clientes = new EditClientes();
	 // clientes.start();
		
	   InterfaceAgendamentos agendamentos = new InterfaceAgendamentos();
	   agendamentos.Start();
	    	
	 //  InterfaceCadastroTemas cadastrartemas = new InterfaceCadastroTemas();
	//   cadastrartemas.Start();
		
	//	  EditTemas temas = new EditTemas();
		//  temas.start();
    
     
		
		
	}

	
}
