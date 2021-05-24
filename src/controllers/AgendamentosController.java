package controllers;
import javax.swing.JOptionPane;
import list.List;
import models.Agendamentos;
import services.TXTService;

public class AgendamentosController {
	
	public AgendamentosController(TXTService<Agendamentos> txts) {
        this.txtService = txts;
    }
	
	 private TXTService<Agendamentos> txtService;
	  public void create(Agendamentos agendamentos) {
		  if(consultaagendamentos(agendamentos.getData(), agendamentos.getTema(), txtService.read())) {
	    	  JOptionPane.showMessageDialog(null,"O mesmo Tema só pode ser Agendado uma vez por Dia!");  
	       }
	       else {
	    	 txtService.create(agendamentos);
	       }
	       
	  }
	 
		public boolean consultaagendamentos(String date, String tema, List<String> list) {
	   		if(list.toString().contains(date) && list.toString().contains(tema)) {
	   			return true;
	   		}
	   		else {
	   			return false;
	   		}
	   	}
		
	
}
