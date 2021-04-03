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
		// Ainda arrumar isso
//		List<String> clientTXT = txtService.read();
		return new List<>();
	}
}
