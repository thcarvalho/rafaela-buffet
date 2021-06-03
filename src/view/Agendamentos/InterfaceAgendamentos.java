package view.Agendamentos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ClientController;
import controllers.TemasController;
import models.Client;
import models.Temas;
import services.TXTService;
import models.Agendar;
import controllers.AgendamentosController;
import models.Historico;
import controllers.historicoController;


public class InterfaceAgendamentos extends JFrame {

	private JPanel contentPane;
	
	TXTService<Agendar> txtagendados = new TXTService<>("agendados.txt");
	AgendamentosController agendamentocontroller = new AgendamentosController(txtagendados);

	public void Start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAgendar frame = new InterfaceAgendar();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
		public InterfaceAgendamentos() {
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 565, 561);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			
		}

}

