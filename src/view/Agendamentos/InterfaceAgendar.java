package view.Agendamentos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.security.sasl.Sasl;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import controllers.ClientController;
import controllers.TemasController;
import models.Client;
import models.Temas;
import services.TXTService;
import models.Agendar;
import controllers.AgendamentosController;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import models.Historico;
import controllers.historicoController;

public class InterfaceAgendar extends JFrame {

	TXTService<Agendar> txtagendamento = new TXTService<>("agendamentos.txt");
	AgendamentosController agendamentocontroller = new AgendamentosController(txtagendamento);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboClientes;
	private JComboBox<String> comboTemas;
	private JButton Agendar;
	private JCalendar calendar_1;
	private JFormattedTextField Endereco;
	private JFormattedTextField horario;
	private JLabel FundoTemas;
	private JButton Sair;
	

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

	public InterfaceAgendar() {

		TXTService<Client> txtclient = new TXTService<>("client.txt");
		ClientController clientcontroller = new ClientController(txtclient);

		TXTService<Temas> txttemas = new TXTService<>("temas.txt");
		TemasController temascontroller = new TemasController(txttemas);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboClientes = new JComboBox<String>();
		comboClientes.setBounds(80, 349, 336, 22);
		String select[] = clientcontroller.read().toString().split("\n");
		for (String n : select) {
			String clients[] = n.split(",");
			comboClientes.addItem(clients[0]);
		}
		contentPane.add(comboClientes);

		comboTemas = new JComboBox<String>();
		comboTemas.setBounds(80, 400, 336, 22);
		String selectt[] = temascontroller.read().toString().split("\n");
		for (String n : selectt) {
			String temas[] = n.split(",");
			comboTemas.addItem(temas[0]);
		}
		contentPane.add(comboTemas);

		Agendar = new JButton("Agendar");
		Agendar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String client = comboClientes.getSelectedItem().toString().trim();
				String temas = comboTemas.getSelectedItem().toString().trim();
				String dt[] = calendar_1.getDate().toString().split(" ");
				StringBuffer datas = new StringBuffer();
				datas.append(dt[1] + "/");
				datas.append(dt[2] + " ");
				datas.append(dt[5]);
				String data = datas.toString();
				String hr = horario.getText();
				String endereco = Endereco.getText();
				Agendar agendamentos = new Agendar(client, temas, data, hr, endereco);
				agendamentos.setClient(client);
				agendamentos.setTema(temas);
				agendamentos.setData(data);
				agendamentos.setHorario(hr);
				agendamentocontroller.create(agendamentos);
				Historico history = null;
				try {
					history = new Historico(clientcontroller.getByName(client).toString(), data, hr, temas);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				TXTService<Historico> txthystory = new TXTService<>("historico.txt");
                historicoController historyc = new historicoController(txthystory);
                historyc.create(history);
                
				// ----------Esvaziar Campos

				horario.setText(" ");
				Endereco.setText(" ");

			}

		});
		Agendar.setForeground(Color.DARK_GRAY);
		Agendar.setBackground(SystemColor.controlHighlight);
		Agendar.setBounds(326, 447, 89, 23);
		contentPane.add(Agendar);

		calendar_1 = new JCalendar();
		calendar_1.getYearChooser().getSpinner().setForeground(Color.LIGHT_GRAY);
		calendar_1.getMonthChooser().getComboBox().setForeground(new Color(0, 0, 0));
		calendar_1.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		calendar_1.getDayChooser().getDayPanel().setBackground(new Color(216, 191, 216));
		calendar_1.setBounds(232, 137, 265, 130);
		contentPane.add(calendar_1);

		horario = new JFormattedTextField();
		horario.setBounds(73, 188, 132, 31);
		contentPane.add(horario);
		
	    Endereco = new JFormattedTextField();
		Endereco.setBounds(73, 278, 424, 31);
		contentPane.add(Endereco);
		
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
		
		FundoTemas = new JLabel("New label");
		Icon img = new ImageIcon("img/FundoAgendamento.png");
		FundoTemas.setIcon(img);
        FundoTemas.setBounds(0, 0, 549, 522);
		contentPane.add(FundoTemas);
	}
}