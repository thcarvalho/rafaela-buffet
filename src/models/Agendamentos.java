package models;
public class Agendamentos {
	
	private String client;
	private String tema;
	private int desconto;
	private String data;
	private String horario;
	private String endereco;
	private int valortema;
   
	
	public Agendamentos(boolean desc) {
		super();
		if(desc) {
		  this.desconto = (10/100);
		}
		else {
			this.desconto  = 1;
		}
	}

	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}



	public String getTema() {
		return tema;
	}



	public void setTema(String tema) {
		this.tema = tema;
	}



	public int getValortema() {
		return valortema;
	}



	public void setValortema(int valortema) {
		this.valortema = valortema - (valortema * desconto);
	}

	public int getDesconto() {
		return desconto;
	}



	public void setDesconto(int desconto) {
		this.desconto = desconto;
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



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	@Override
	public String toString() {
		return client + "," + tema + "," + data + ","+ horario + "," + endereco + "," + valortema + ",";
	}


}
 