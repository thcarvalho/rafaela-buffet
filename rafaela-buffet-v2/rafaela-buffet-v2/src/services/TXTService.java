package services;

import list.List;
import models.Client;
import models.Temas;

import java.io.*;

public class TXTService<T> {
	private String fileName;
	private List<String> store;

	public TXTService(String fileName) {
		this.fileName = fileName;
		store = read();
	}

	public void saveClient() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(store.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveTemas() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(store.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createClient(Client client) {
		store.add(client.toString());
		saveClient();
	}
	public void createTemas(Temas tema) {
		store.add(tema.toString());
		saveTemas();
	}

	public List<String> read() {
		if (!fileExists()) {
			return new List<>();
		}
		List<String> modelList = new List<>();
		try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))){
			String line = buffer.readLine();
			while (line != null) {
				modelList.add(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	

	public void deleteClient(Client client) {
		try {
			store.remove(client.toString());
			saveClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTemas(Temas temas) {
		try {
			store.remove(temas.toString());
			saveTemas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean fileExists() {
		File f = new File(fileName);
		return f.exists();
	}
	
}
