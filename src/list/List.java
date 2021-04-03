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

	public void remove(T data) throws Exception {
		if (length == 0) {
			throw new Exception("Lista vazia");
		}

		if (length == 1) {
			head = null;
			length--;
			return;
		}

		Node<T> current = head;
		while (current != null) {
			if (current.getData().equals(data)) {
				Node<T> temp = current.getNext();
				current.setNext(temp.getNext());
				return;
			}
			current = current.getNext();
		}

		throw new Exception("Elemento n�o encontrado");
	}

	// ------Checando se o CPF j� foi cadastrado
//    public boolean consultaCpf(String cpf, String data) {
//
//        if (data.contains(cpf)) {
//            JOptionPane.showMessageDialog(null, "CPF cadastrado!");
//            return false;
//        }
//        return true;
//    }

}
