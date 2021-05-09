package controllers;
import javax.swing.JOptionPane;
import models.Agendamentos;
import services.TXTService;

public class AgendamentosController {
	
	public AgendamentosController(TXTService<Agendamentos> txts) {
        this.txtService = txts;
    }
	
	 private TXTService<Agendamentos> txtService;
	 public void create(Agendamentos agendamentos) {
	        txtService.create(agendamentos);
	       
	  }
	
}
