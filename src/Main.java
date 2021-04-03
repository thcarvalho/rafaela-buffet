import controllers.ClientController;
import list.List;
import models.Client;
import services.TXTService;

public class Main {
	public static void main(String[] args) {
		TXTService<Client> txtService = new TXTService<>("client.txt");
		ClientController clientController = new ClientController(txtService);
		Client client = new Client("123123123", "Teste", "teste@teste", "1123452345");
		clientController.create(client);
		List<String> list = txtService.read();
		System.out.println(list.toString());
	}
}
