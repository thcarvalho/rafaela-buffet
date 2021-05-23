package view.Agendamentos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import models.Agendamentos;
import controllers.AgendamentosController;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class InterfaceAgendamentos extends JFrame {

	TXTService<Agendamentos> txtagendamento = new TXTService<>("agendamentos.txt");
	AgendamentosController agendamentocontroller = new AgendamentosController(txtagendamento);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboClientes;
	private JComboBox<String> comboTemas;
	private JButton Agendar;
	private JButton Sair;
	private JCalendar calendar;
	private JLabel FundoAgendamento;
	private JFormattedTextField horario;

	public void Start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAgendamentos frame = new InterfaceAgendamentos();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfaceAgendamentos() {

		TXTService<Client> txtclient = new TXTService<>("client.txt");
		ClientController clientcontroller = new ClientController(txtclient);

		TXTService<Temas> txttemas = new TXTService<>("temas.txt");
		TemasController temascontroller = new TemasController(txttemas);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboClientes = new JComboBox<String>();
		comboClientes.setBounds(107, 143, 289, 22);
		String select[] = clientcontroller.read().toString().split("\n");
		for (String n : select) {
			String clients[] = n.split(",");
			comboClientes.addItem(clients[0]);
		}
		contentPane.add(comboClientes);

		comboTemas = new JComboBox<String>();
		comboTemas.setBounds(107, 201, 289, 22);
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
				String dt[] = calendar.getDate().toString().split(" ");
				StringBuffer datas = new StringBuffer();
				datas.append(dt[1] + " ");
				datas.append(dt[2] + " ");
				datas.append(dt[5] + " ");
				String data = datas.toString();
				String hr = horario.getText();
				Agendamentos agendamentos = new Agendamentos(client, temas, data, hr);
				agendamentos.setClient(client);
				agendamentos.setTema(temas);
				agendamentos.setData(data);
				agendamentos.setHorario(hr);
				agendamentocontroller.create(agendamentos);

				// ----------Esvaziar Campos

				horario.setText(" ");

			}

		});
		Agendar.setForeground(Color.DARK_GRAY);
		Agendar.setBackground(SystemColor.controlHighlight);
		Agendar.setBounds(283, 406, 89, 23);
		contentPane.add(Agendar);

		Sair = new JButton("Sair");
		Sair.setBounds(382, 406, 89, 23);
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setBackground(SystemColor.controlHighlight);
		contentPane.add(Sair);

		calendar = new JCalendar();
		calendar = new JCalendar();
		calendar.setBounds(206, 234, 223, 152);
		contentPane.add(calendar);

		horario = new JFormattedTextField();
		horario.setBounds(107, 274, 89, 31);
		contentPane.add(horario);

		FundoAgendamento = new JLabel("");
		Icon img = new ImageIcon("img/agendamentos.png");
		FundoAgendamento.setIcon(img);
		FundoAgendamento.setBounds(-10, 11, 498, 454);
		contentPane.add(FundoAgendamento);
	}
}
