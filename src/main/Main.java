package main;
import view.Main.*;
import java.awt.Window.Type;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Agendamentos.InterfaceAgendamentos;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	//   InterfaceAgendamentos agendamentos = new InterfaceAgendamentos();
	 //  agendamentos.Start();
	    
	 Vmain main = new Vmain();
	 main.start();
	
	}

	
}
