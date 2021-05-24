package models;

public class Historico {

	private String cliente;
	private String agendamento;
	private String horario;
    private String tema;
    
    
    
	public Historico(String cliente, String agendamento, String horario, String tema) {
		super();
		this.cliente = cliente;
		this.agendamento = agendamento;
		this.horario = horario;
		this.tema = tema;
	}

	public Historico() {
		
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(String agendamento) {
		this.agendamento = agendamento;
	}
    
	@Override
	public String toString() {
		return cliente + agendamento + "," + horario + "," + tema + ",";
	}

	

	
}
