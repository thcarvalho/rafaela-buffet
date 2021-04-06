package services;

import list.List;
import models.Client;
import java.io.*;

public class TXTService<T> {
	private String fileName;
	private List<String> store;

	public TXTService(String fileName) {
		this.fileName = fileName;
		store = read();
	}

	public void save() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(store.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void create(Client client) {
		store.add(client.toString());
		save();
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
	

	public void delete(Client client) {
		try {
			store.remove(client.toString());
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean fileExists() {
		File f = new File(fileName);
		return f.exists();
	}
	
}
