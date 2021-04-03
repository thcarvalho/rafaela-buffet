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
}
