package view.Cadastros;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Formatter;


public class InterfaceCadastroTemas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nome;
	private JButton CadastrarTema;
	private JButton SairTemas;
	private JFormattedTextField ValorTema;
	private JTextArea DescricaoTema;
	private JLabel FundoTema;
	

	public void Start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroTemas frame = new InterfaceCadastroTemas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InterfaceCadastroTemas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nome = new JTextField();
		Nome.setBounds(152, 137, 302, 20);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		DescricaoTema = new JTextArea();
		DescricaoTema.setBounds(182, 181, 272, 68);
		contentPane.add(DescricaoTema);
		
		
		ValorTema = new JFormattedTextField();
		ValorTema.setBounds(225, 280, 88, 33);
		contentPane.add(ValorTema);
		
		CadastrarTema = new JButton("Cadastrar");
		CadastrarTema.setForeground(Color.DARK_GRAY);
		CadastrarTema.setBackground(SystemColor.controlHighlight);
		CadastrarTema.setFont(new Font("Arial", Font.PLAIN, 14));
		CadastrarTema.setBounds(251, 380, 101, 23);
		contentPane.add(CadastrarTema);
		
		SairTemas = new JButton("Sair");
		SairTemas.setForeground(Color.DARK_GRAY);
		SairTemas.setFont(new Font("Arial", Font.PLAIN, 14));
		SairTemas.setBackground(SystemColor.controlHighlight);
		SairTemas.setBounds(362, 380, 101, 23);
		contentPane.add(SairTemas);
		
		JLabel lblsifrao = new JLabel("R$");
		lblsifrao.setFont(new Font("Arial", Font.PLAIN, 16));
		lblsifrao.setForeground(Color.WHITE);
		lblsifrao.setBounds(316, 289, 46, 24);
		contentPane.add(lblsifrao);
		
		FundoTema = new JLabel("");
		FundoTema.setBackground(SystemColor.menu);
		Icon img = new ImageIcon("img/CadastroTema.png");
        FundoTema.setIcon(img);
		FundoTema.setBounds(0, 0, 498, 454);
		contentPane.add(FundoTema);	
		
		CadastroTemas cmd = new CadastroTemas(Nome,DescricaoTema,ValorTema);
		CadastrarTema.addActionListener(cmd);	
		SairTemas.addActionListener(cmd);
		
	}
}
