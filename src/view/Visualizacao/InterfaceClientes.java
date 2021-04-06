package view.Visualizacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea InfoCliente;
	private JComboBox Cliente;
	private JButton Excluir;
	private JButton Sair;
	private JLabel FundoExibirCliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientes frame = new InterfaceClientes();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfaceClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Cliente = new JComboBox();
		Cliente.setBounds(83, 176, 324, 22);
		contentPane.add(Cliente);
		
		InfoCliente = new JTextArea();
		InfoCliente.setBounds(83, 269, 324, 99);
		contentPane.add(InfoCliente);
		
	    Excluir = new JButton("Excluir");
	    Excluir.setForeground(Color.DARK_GRAY);
		Excluir.setFont(new Font("Arial", Font.PLAIN, 14));
		Excluir.setBackground(SystemColor.controlHighlight);
		Excluir.setBounds(240, 394, 89, 23);
		contentPane.add(Excluir);
		
		Sair = new JButton("Sair");
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setFont(new Font("Arial", Font.PLAIN, 14));
		Sair.setBackground(SystemColor.controlHighlight);
		Sair.setBounds(351, 394, 89, 23);
		contentPane.add(Sair);
		
		FundoExibirCliente = new JLabel("");
		Icon img = new ImageIcon("img/VisualizarClientes.png");
		FundoExibirCliente.setIcon(img);
		FundoExibirCliente.setBounds(0, 0, 498, 454);
		contentPane.add(FundoExibirCliente);
		
	} 

}
