package models;
public class Agendamentos {
	
	private String client;
	private String tema;
	private String data;
	private String horario;
	
	public Agendamentos(String client, String tema,String data, String horario) {
		super();
		this.client = client;
		this.tema = tema;
		this.data = data;
		this.horario = horario;
			
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
	
	@Override
	public String toString() {
		return client + "," + tema + "," + data + ","+ horario + ",";
	}


}
 