package view.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//-----------VIEWS

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

public class Vmain extends JFrame {

	private JPanel contentPane;
	private JLabel FundoMain;
	private JButton festasagendadas;
	private JButton agendarfesta;
	private JButton temas;
	private JButton clientes;
	private JButton CadastroCliente;
	private JButton CadastroTema;
    private JButton Sair;
    
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vmain frame = new Vmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Vmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CadastroTema = new JButton("CADASTRAR TEMA");
		CadastroTema.setForeground(Color.DARK_GRAY);
		CadastroTema.setFont(new Font("Arial", Font.PLAIN, 14));
		CadastroTema.setBackground(SystemColor.controlHighlight);
		CadastroTema.setBounds(142, 167, 243, 31);
		
		CadastroTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 InterfaceCadastroTemas cadastrartemas = new InterfaceCadastroTemas();
		     cadastrartemas.Start();
		     
			}
		});
		
		contentPane.add(CadastroTema);
		
		CadastroCliente = new JButton("CADASTRAR CLIENTE");
		CadastroCliente.setBounds(142, 226, 243, 31);
		CadastroCliente.setForeground(Color.DARK_GRAY);
		CadastroCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		CadastroCliente.setBackground(SystemColor.controlHighlight);

		CadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceCadastroCliente cadastrarclientes = new InterfaceCadastroCliente();
			    cadastrarclientes.Start();
			}
		});
		
		contentPane.add(CadastroCliente);
		
		clientes = new JButton("CLIENTES");
		clientes.setBounds(142, 326, 243, 31);
		clientes.setForeground(Color.DARK_GRAY);
		clientes.setFont(new Font("Arial", Font.PLAIN, 14));
		clientes.setBackground(SystemColor.controlHighlight);

		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
			EditClientes clientes = new EditClientes();
		    clientes.start();
			 
			}
		});
		contentPane.add(clientes);
		
		temas = new JButton("TEMAS");
		temas.setBounds(96, 352, 209, 31);
		temas.setForeground(Color.DARK_GRAY);
		temas.setFont(new Font("Arial", Font.PLAIN, 14));
		temas.setBackground(SystemColor.controlHighlight);
		
		temas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 EditTemas temas = new EditTemas();
		     temas.start();
			}
		});
		temas.setBounds(142, 276, 243, 31);
		contentPane.add(temas);
		
		
		agendarfesta = new JButton("AGENDAR EVENTO");
		agendarfesta.setBounds(141, 380, 244, 31);
		agendarfesta.setForeground(Color.DARK_GRAY);
		agendarfesta.setFont(new Font("Arial", Font.PLAIN, 14));
		agendarfesta.setBackground(SystemColor.controlHighlight);
		
		agendarfesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		     InterfaceAgendar agendar = new InterfaceAgendar();
		     agendar.Start();
			}
		});
		
		contentPane.add(agendarfesta);
	

		festasagendadas = new JButton("AGENDAMENTOS");
		festasagendadas.setForeground(Color.DARK_GRAY);
		festasagendadas.setFont(new Font("Arial", Font.PLAIN, 14));
		festasagendadas.setBackground(SystemColor.controlHighlight);
		festasagendadas.setBounds(142, 437, 243, 31);
		
		festasagendadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			InterfaceAgendamentos agendamentos = new InterfaceAgendamentos();
		    agendamentos.Start();
		    
			}
		});
		
		contentPane.add(festasagendadas);
		
		Sair = new JButton("Sair");
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setFont(new Font("Arial", Font.PLAIN, 14));
		Sair.setBackground(SystemColor.controlHighlight);
		Sair.setBounds(226, 491, 89, 23);
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		contentPane.add(Sair);
	
		
		FundoMain = new JLabel("");
		Icon img = new ImageIcon("img/FundoMain.png");
		FundoMain.setIcon(img);
		FundoMain.setBounds(0, 0, 575, 568);
		contentPane.add(FundoMain);
		
		
	}
}
