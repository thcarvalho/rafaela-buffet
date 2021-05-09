package list;

import controllers.ClientController;

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

    //--------Remove dados da Lista

    public void remove(T data) throws Exception {
        if (length == 0) throw new Exception("Lista vazia");

        if (length == 1) {
            head = null;
            length--;
            return;
        }

        Node<T> current = head;

        if (length == getPosition(data)) {
            while (current != null) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(null);
                    length--;
                    return;
                }
                current = current.getNext();
            }
        }


        while (current != null) {
            if (current.getData().equals(data)) {
                Node<T> temp = current.getNext();
                current.setNext(temp.getNext());
                length--;
                return;
            }
            current = current.getNext();
        }

        for (Node<T> node = head; node.getNext() != null; node = node.getNext()) {

        }

        throw new Exception("Elemento não encontrado");
    }

    public int getPosition(T data) throws Exception {
        Node<T> current = head;

        if (current == null) throw new Exception("Lista vazia");
        int position = 1;

        while (current != null) {
            if (current.getData().equals(data)) {
                break;
            }
            current = current.getNext();
            position++;
        }

        return position;
    }

}
