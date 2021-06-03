package view.Main;

import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import view.Agendamentos.InterfaceAgendar;

public class test extends JPanel {

	 InterfaceAgendar agendar = new InterfaceAgendar();
	
	public test() {
		setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(188, 5, 262, 295);
		add(internalFrame);
		internalFrame.setVisible(true);

	}

}
