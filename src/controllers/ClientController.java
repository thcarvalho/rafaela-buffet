package controllers;

import list.List;
import models.Client;
import services.TXTService;

public class ClientController {
    private TXTService<Client> txtService;

    public ClientController(TXTService<Client> txtService) {
        this.txtService = txtService;
    }

    public void create(Client client) {
        // Dá pra colocar a lógica de verificar CPF aqui
        txtService.create(client);
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

        throw new Exception("Cliente não encontrado");
    }

    public void delete(String CPF) {
        try {
            Client client = getByCPF(CPF);
            txtService.delete(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
