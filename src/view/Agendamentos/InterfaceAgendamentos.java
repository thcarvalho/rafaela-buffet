package view.Agendamentos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JButton;


public class InterfaceAgendamentos extends JFrame {

	private JPanel contentPane;
	private JButton Sair;
	
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
		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 565, 561);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			Sair = new JButton("Sair");
			Sair.setForeground(Color.DARK_GRAY);
			Sair.setFont(new Font("Arial", Font.PLAIN, 14));
			Sair.setBackground(SystemColor.controlHighlight);
			Sair.setBounds(426, 447, 89, 23);
			Sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	             System.exit(DO_NOTHING_ON_CLOSE);
				}
			});
			contentPane.add(Sair);
		
		}

}

