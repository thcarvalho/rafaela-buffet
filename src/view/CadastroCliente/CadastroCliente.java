package view.CadastroCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

import models.Client;
import list.List;

public class CadastroCliente implements ActionListener {

    private JFormattedTextField Nome;
    private JFormattedTextField CPF;
    private JFormattedTextField Email;
    private JFormattedTextField Tel;


    public CadastroCliente(JFormattedTextField nome, JFormattedTextField cpf, JFormattedTextField email,
                           JFormattedTextField tel) {
        Nome = nome;
        CPF = cpf;
        Email = email;
        Tel = tel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Cadastrar")) {
            adicionar(CPF.getText(), Nome.getText(), Tel.getText(), Email.getText());
        }
        if (cmd.equals("Sair")) {
            //------Back Janela Inicial
        }
    }


    public void adicionar(String CPF, String Nome, String Tel, String Email) {
//        List<Client> Listacadastro = new List<>();
//        if (Listacadastro.consultaCpf(CPF, Listacadastro.toString())) {
//            Client client = new Client(CPF, Email, Nome, Tel);
//
//            //-----Gerando Lista
//            String dados = Listacadastro.dadoscliente(
//                    client.getCPF(),
//                    client.getName(),
//                    client.getEmail(),
//                    client.getTel()
//            );
//
//            Listacadastro.add(dados);
//        }


        //----------Esvaziar Campos
        this.Nome.setText(" ");
        this.CPF.setText(" ");
        this.Email.setText(" ");
        this.Tel.setText(" ");
    }

}
