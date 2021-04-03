package list;

public class List<T> {
	private Node<T> head;
	public int length;

	// -------Colocando dados na Lista
	public void add(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);
		head = node;
		length++;
	}

	// ---------Lista Completa
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> current = head;
		while (current != null) {
			T model = current.getData();
			sb.append(model.toString() + "\n");
			current = current.getNext();
		}
		return sb.toString();
	}

	// ------Checando se o CPF já foi cadastrado
//    public boolean consultaCpf(String cpf, String data) {
//
//        if (data.contains(cpf)) {
//            JOptionPane.showMessageDialog(null, "CPF cadastrado!");
//            return false;
//        }
//        return true;
//    }

}
