import javax.swing.JOptionPane;
public class Teste {
	public static void main(String args[]) {
		ListaDuplamenteEncadeada l=new ListaDuplamenteEncadeada();
		int op=0,dado,pos=0;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("1-Adiciona Final\n2-Adiciona Início\n"
					+ "3-Remove Final\n4-Remove Início\n5-Exibir\n99-Sair"));
			switch(op){
			case 1:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaFinal(dado);
				break;
			case 2:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaInicio(dado);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveFinal());
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveInicio());
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Lista:"+l.percorre());
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Posição inválida");
			}
		}


	}
}
