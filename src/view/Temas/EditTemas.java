package view.Temas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controllers.TemasController;
import models.Temas;
import services.TXTService;


@SuppressWarnings("unused")
public class EditTemas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea InfoTema;
	private JComboBox <String> Temas;
	private JButton Excluir;
	private JLabel FundoExibirTemas;
    private JButton Sair;
    
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					EditTemas frame = new EditTemas();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EditTemas() {
		
		TXTService<Temas> txtclient = new TXTService<>("temas.txt");
		TemasController temascontroller = new TemasController(txtclient);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Temas = new JComboBox <String>();
		 String select[] = temascontroller.read().toString().split("\n");
     	 for(String n: select) {	
			String temas[] = n.split(",");
			 Temas.addItem(temas[0]);
		  }

		 Temas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setinfos();
				}
			});
		
		Temas.setBounds(73, 156, 302, 31);
		contentPane.add(Temas);
		
		
		InfoTema = new JTextArea();
		InfoTema.setBounds(73, 246, 302, 104);
		contentPane.add(InfoTema);
		
	    Excluir = new JButton("Excluir");
	    Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 temascontroller.delete(Temas.getSelectedItem().toString().trim());
			 JOptionPane.showMessageDialog(null,setinfos()+"\nTema Excluido!");
			 InfoTema.setText(" ");
			 
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
	
		
		FundoExibirTemas = new JLabel("");
		Icon img = new ImageIcon("img/FundoEditTema.png");
		FundoExibirTemas.setIcon(img);
		FundoExibirTemas.setBounds(0, 0, 498, 454);
		contentPane.add(FundoExibirTemas);
	  }
	
     
	  public String setinfos() {		  
		 TXTService<Temas> txtclient = new TXTService<>("temas.txt");
	     TemasController temascontroller = new TemasController(txtclient);  
		 String selectinfo[] = temascontroller.read().toString().split(",");
		 StringBuffer info = new StringBuffer();	
		 
		 int cont2 = 4; 
    	 for(String n: selectinfo) {	
    	  if(n.contains(Temas.getSelectedItem().toString().trim()) || cont2 != 4) {
		    info.append("\n"+n);
		    cont2 -= 1;
		    if(cont2 == 0) {
		    	cont2 = 4;
		    }
    	  }
		  }
	      InfoTema.setText(info.toString().trim());
	      return info.toString();
	  }  
		
	 
}
