package util;
import javax.swing.JOptionPane;

public class ListCadastroCliente <T>{
 
    private Node<T> head;
		  
   //---------Unindo Dados dos Clientes
	public String dadoscliente(String cpf, String nome, String email, String tel) {	
	  StringBuffer cliente = new StringBuffer();
	  cliente.append("\n CPF: " + cpf);
	  cliente.append("\n Nome: " + nome);
	  cliente.append("\n Email: " + email);
	  cliente.append("\n Telefone: " + tel);
	  return cliente.toString();
	}
	
	//-------Colocando dados na Lista
	public void lista(T dados) {
	   Node<T> node = new Node<T>();
	   node.setData(dados);
	   node.setNext(head);
	   head = node;
	}
	
	//---------Lista Completa
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> p = head;
		while(p != null) {
		  sb.append("\n Cliente: ");
		  sb.append(p.getData() + "\n");
		  p = p.getNext();
		}
		return sb.toString();
	}
	
	
	//------Checando se o CPF já foi cadastrado
	 public boolean consultaCpf(String cpf, String data) {
		 
		  if(data.contains(cpf)) {
		   JOptionPane.showMessageDialog(null, "CPF cadastrado!");
		   return false;
		  }
		  else {  
			return true;
		  }	  
		} 	
	
}
