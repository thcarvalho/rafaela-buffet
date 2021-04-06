package view.Cadastros;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class InterfaceCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField Nome;
	private JFormattedTextField CPF;
	private JFormattedTextField Email;
	private JFormattedTextField Tel;
	private JButton Cadastrar;
	private JButton Sair;
	private JLabel FundoCliente;
	

	public void Start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroCliente frame = new InterfaceCadastroCliente();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfaceCadastroCliente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
			
		Nome = new JFormattedTextField();
		Nome.setForeground(Color.BLACK);
		Nome.setBackground(Color.WHITE);
		Nome.setBounds(149, 134, 292, 20);
		contentPane.add(Nome);
		
		CPF = new JFormattedTextField();
		CPF.setForeground(Color.BLACK);
		CPF.setBackground(Color.WHITE);
		CPF.setBounds(149, 183, 292, 20);
		contentPane.add(CPF);
		
		Email = new JFormattedTextField();
		Email.setForeground(Color.BLACK);
		Email.setBackground(Color.WHITE);
		Email.setBounds(149, 230, 292, 20);
		contentPane.add(Email);
		
		Tel = new JFormattedTextField();
		Tel.setForeground(Color.BLACK);
		Tel.setBackground(Color.WHITE);
		Tel.setBounds(172, 279, 269, 20);
		contentPane.add(Tel);
		
		Cadastrar = new JButton("Cadastrar");
		Cadastrar.setForeground(Color.DARK_GRAY);
		Cadastrar.setBackground(SystemColor.controlHighlight);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		Cadastrar.setBounds(230, 356, 101, 23);
		contentPane.add(Cadastrar);
		
		Sair = new JButton("Sair");
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setBackground(SystemColor.controlHighlight);
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Sair.setFont(new Font("Arial", Font.PLAIN, 14));
		Sair.setBounds(348, 356, 93, 23);
		contentPane.add(Sair);
	
		FundoCliente = new JLabel("");
		FundoCliente.setBackground(SystemColor.menu);
		Icon img = new ImageIcon("img/CadastroCliente.jpg");
        FundoCliente.setIcon(img);
		FundoCliente.setBounds(0, 0, 498, 454);
		contentPane.add(FundoCliente);	
		
		CadastroCliente cmd = new CadastroCliente(Nome,CPF,Email,Tel);
		Cadastrar.addActionListener(cmd);
		
	}
}