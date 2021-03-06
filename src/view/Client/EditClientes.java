package view.Client;
import controllers.ClientController;
import models.Client;
import services.TXTService;
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
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea InfoCliente;
	private JComboBox <String> Cliente;
	private JButton Excluir;
	private JLabel FundoExibirCliente;
	private JButton Sair;

	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClientes frame = new EditClientes();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EditClientes() {
		
		TXTService<Client> txtclient = new TXTService<>("client.txt");
		ClientController clientcontroller = new ClientController(txtclient);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Cliente = new JComboBox <String>();
		 String select[] = clientcontroller.read().toString().split("\n");
     	 for(String n: select) {	
			String clients[] = n.split(",");
			 Cliente.addItem(clients[0]);
		  }

		 Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setinfos();
				}
			});
		
		Cliente.setBounds(83, 176, 324, 22);
		contentPane.add(Cliente);
		
		
		InfoCliente = new JTextArea();
		InfoCliente.setBounds(83, 269, 324, 99);
		contentPane.add(InfoCliente);
		
	    Excluir = new JButton("Excluir");
	    Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 clientcontroller.delete(Cliente.getSelectedItem().toString().trim());
			 JOptionPane.showMessageDialog(null,setinfos()+"\nCliente Excluido!");
			 InfoCliente.setText(" ");
			 	 
			}
		});
		
	    Excluir.setForeground(Color.DARK_GRAY);
		Excluir.setFont(new Font("Arial", Font.PLAIN, 14));
		Excluir.setBackground(SystemColor.controlHighlight);
		Excluir.setBounds(240, 394, 89, 23);
		contentPane.add(Excluir);
		
		Sair = new JButton("Sair");
		Sair.setForeground(Color.DARK_GRAY);
		Sair.setFont(new Font("Arial", Font.PLAIN, 14));
		Sair.setBackground(SystemColor.controlHighlight);
		Sair.setBounds(345, 394, 89, 23);
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		contentPane.add(Sair);
		
		
		
		FundoExibirCliente = new JLabel("");
		Icon img = new ImageIcon("img/VisualizarClientes.png");
		FundoExibirCliente.setIcon(img);
		FundoExibirCliente.setBounds(0, 0, 498, 454);
		contentPane.add(FundoExibirCliente);
	  }
	
     
	  public String setinfos() {		  
		 TXTService<Client> txtclient = new TXTService<>("client.txt");
	     ClientController clientcontroller = new ClientController(txtclient);  
		 String selectinfo[] = clientcontroller.read().toString().split(",");
		 StringBuffer info = new StringBuffer();	
		 
		 int cont2 = 4; 
    	 for(String n: selectinfo) {	
    	  if(n.contains(Cliente.getSelectedItem().toString().trim()) || cont2 != 4) {
		    info.append("\n"+n);
		    cont2 -= 1;
		    if(cont2 == 0) {
		    	cont2 = 4;
		    }
    	  }
		  }
	      InfoCliente.setText(info.toString().trim());
	      return info.toString();
	  }  
		
	} 


