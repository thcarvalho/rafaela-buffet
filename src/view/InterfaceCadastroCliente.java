package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import controller.CadastroCliente;

public class InterfaceCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroCliente frame = new InterfaceCadastroCliente();
					frame.setVisible(true);
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
			
		JFormattedTextField Nome = new JFormattedTextField();
		Nome.setForeground(Color.BLACK);
		Nome.setBackground(Color.WHITE);
		Nome.setBounds(149, 134, 292, 20);
		contentPane.add(Nome);
		
		JFormattedTextField CPF = new JFormattedTextField();
		CPF.setForeground(Color.BLACK);
		CPF.setBackground(Color.WHITE);
		CPF.setBounds(149, 183, 292, 20);
		contentPane.add(CPF);
		
		JFormattedTextField Email = new JFormattedTextField();
		Email.setForeground(Color.BLACK);
		Email.setBackground(Color.WHITE);
		Email.setBounds(149, 230, 292, 20);
		contentPane.add(Email);
		
		JFormattedTextField Tel = new JFormattedTextField();
		Tel.setForeground(Color.BLACK);
		Tel.setBackground(Color.WHITE);
		Tel.setBounds(172, 279, 269, 20);
		contentPane.add(Tel);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setForeground(Color.DARK_GRAY);
		Cadastrar.setBackground(SystemColor.controlHighlight);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		Cadastrar.setBounds(230, 356, 101, 23);
		contentPane.add(Cadastrar);
		
		JButton Sair = new JButton("Sair");
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setBackground(SystemColor.controlHighlight);
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Sair.setFont(new Font("Arial", Font.PLAIN, 14));
		Sair.setBounds(348, 356, 93, 23);
		contentPane.add(Sair);
		
		JLabel lblFundoCadastroCliente = new JLabel("");
		lblFundoCadastroCliente.setBackground(SystemColor.menu);
		lblFundoCadastroCliente.setIcon(new ImageIcon("C:\\Users\\Karen\\Downloads\\fundofinaal.jpg"));
		lblFundoCadastroCliente.setBounds(0, 0, 498, 454);
		contentPane.add(lblFundoCadastroCliente);
		
		CadastroCliente cmd = new CadastroCliente(Nome,CPF,Email,Tel);
		Cadastrar.addActionListener(cmd);
	}
}
