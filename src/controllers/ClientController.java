package controllers;

import javax.swing.JOptionPane;

import list.List;
import models.Client;
import services.TXTService;
import javax.swing.JOptionPane;

public class ClientController {
    private TXTService<String> txtService;

    public ClientController(TXTService<String> txts) {
        this.txtService = txts;
    }

    public void create(Client client) {
       if(consultacpf(client.getCPF(),txtService.read())) {
    	  JOptionPane.showMessageDialog(null,"Cliente j· Cadastrado!");  
       }
       else {
        txtService.create(client);
       }
    }

	public List<Client> read() {
        List<String> clientTXT = txtService.read();
        List<Client> clients = new List<>();

        String[] lines = clientTXT.toString().split("\n");
        for (String line : lines) {
            String[] data = line.split(",");
            String name = data[0];
            String CPF = data[1];
            String email = data[2];
            String tel = data[3];

            Client client = new Client(CPF, name, email, tel);
            clients.add(client);
        }

        return clients;
    }

    public Client getByCPF(String CPF) throws Exception {
        List<Client> clientsList = read();
        String[] clients = clientsList.toString().split("\n");
        Client client;

        for (String line : clients) {
            if (line.contains(CPF)) {
                String[] data = line.split(",");
                String name = data[0];
                String cpf = data[1];
                String email = data[2];
                String tel = data[3];
                client = new Client(cpf, name, email, tel);
                return client;
            }
        }

        throw new Exception("Cliente n√£o encontrado");
    }

    public void delete(String CPF) {
        try {
            Client client = getByCPF(CPF);
            txtService.delete(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

   	public boolean consultacpf(String cpf, List<String> list) {
   		if (list.toString().contains(cpf)){
   			return true;
   		}
   		else {
   		   return false;
   		}
   	}
   	
}
