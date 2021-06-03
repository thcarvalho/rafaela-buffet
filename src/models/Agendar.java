package models;
public class Agendar {
	
	private String client;
	private String tema;
	private String data;
	private String horario;
	private String endereco;
	
	public Agendar(String client, String tema,String data, String horario, String endereco) {
		super();
		this.client = client;
		this.tema = tema;
		this.data = data;
		this.horario = horario;
		this.endereco = endereco;
			
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
		return client + "," + tema + "," + data + ","+ horario + "," + endereco + ",";
	}


}
 