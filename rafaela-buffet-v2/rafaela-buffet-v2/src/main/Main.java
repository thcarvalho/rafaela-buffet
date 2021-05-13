package main;

import view.Client.InterfaceCadastroCliente;
import view.Temas.InterfaceCadastroTemas;
import view.Client.InterfaceCadastroCliente;
import view.Client.EditClientes;
import view.Agendamentos.InterfaceAgendamentos;
import javax.swing.JOptionPane;


public class Main {
	public static void main(String[] args) {

		int opc = 0;

		while(opc != 9){
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("\t Menu Cadastro \n-----------------------------------------------\n"
					+ "Digite 1 - Cadastrar cliente \nDigite 2 - Editar cliente \nDigite 3 - Cadastrar tema \nDigite 4 - Realizar agendamento"
					+ " \nDigite 9 - Sair"));
			
			switch(opc){
			case 1:
				InterfaceCadastroCliente cadastrarclientes = new InterfaceCadastroCliente();
				cadastrarclientes.Start();
				opc = 9;
				break;
			
			case 2:
				EditClientes clientes = new EditClientes();
				clientes.start();
				opc = 9;
				break;

			case 3:
				InterfaceCadastroTemas cadastrartemas = new InterfaceCadastroTemas();
				cadastrartemas.Start();
				opc = 9;
				break;
				
			case 4:
			    InterfaceAgendamentos agendamentos = new InterfaceAgendamentos();
			    agendamentos.Start();
			    opc = 9;
			    break;

			case 9:
				System.out.println("Saindo");
				break;	

			default:
				System.out.println("Opção inválida");

			}
		}
	}
}