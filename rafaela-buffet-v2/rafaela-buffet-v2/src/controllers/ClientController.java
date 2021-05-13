package controllers;

import javax.swing.JOptionPane;
import list.List;
import models.Client;
import services.TXTService;
import javax.swing.JOptionPane;

public class ClientController {
	
    private TXTService<Client> txtService;

    public ClientController(TXTService<Client> txts) {
        this.txtService = txts;
    }

    public void create(Client client) {
       if(consultacpf(client.getCPF(),txtService.read())) {
    	  JOptionPane.showMessageDialog(null,"Cliente j� Cadastrado!");  
       }
       else {
        txtService.createClient(client);
       }
    }

	public List<Client> read() {
		
        List<String> clientTXT = txtService.read();
        List<Client> clients = new List<>();

        String[] lines = clientTXT.toString().split("\n");
        for (String line : lines) {
            clients.add(stringToClient(line));
        }

        return clients;
    }

	
    public Client getByName(String nome) throws Exception {
        List<Client> clientsList = read();
        String[] clients = clientsList.toString().split("\n");

        for (String line : clients) {
            if (line.contains(nome)) {
                return stringToClient(line);
            }
        }

        throw new Exception("Cliente não encontrado");
    }

    public void delete(String name) {
        try {
            Client client = getByName(name);
            txtService.deleteClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   	public boolean consultacpf(String cpf, List<String> list) {
   		return list.toString().contains(cpf);
   	}

    private Client stringToClient(String line){
        if (line.isEmpty()) return new Client();
        String[] data = line.split(",");
        String name = data[0];
        String cpf = data[1];
        String email = data[2];
        String tel = data[3];
        return new Client(cpf, name, email, tel);
    }
}
