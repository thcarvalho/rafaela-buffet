package controllers;
import list.List;
import models.Historico;
import models.Temas;
import services.TXTService;

public class historicoController {
 
	public historicoController(TXTService<Historico> txts) {
        this.txtService = txts;
    }
	
	 private TXTService<Historico> txtService;
	  public void create(Historico history) {
	    	 txtService.create(history);
	  }
	 
	  public List<Historico> read() {
	        List<String> HistoricoTXT = txtService.read();
	        List<Historico> history = new List<>();

	        String[] lines = HistoricoTXT.toString().split("\n");
	        for (String line : lines) {
	            history.add(stringToHistory(line));
	        }

	        return history;
	    }
	   
	  private Historico stringToHistory(String line){
	        if (line.isEmpty()) return new Historico();
	        String[] data = line.split(",");
	        StringBuffer client = new StringBuffer();
	        client.append(data[0] + ",");
	        client.append(data[1] + ",");
	        client.append(data[2]+ ",");
	        client.append(data[3]+ ",");
	        String cliente = client.toString();
	        String agendamento = data[4];
	        String horario = data[5];
	        String tema = data[6];
	        return new Historico(cliente, agendamento, horario, tema);
	    }  
	  
	   public String getByCPF(String cpf) {
	        List<Historico> historyList = read();
	        String[] history = historyList.toString().split("\n");
            StringBuffer registros = new StringBuffer();
	        for (String line : history) {
	            if (line.contains(cpf)) {
	            	registros.append(line + "\n");
	            }
	        }
	        return registros.toString();
	    }
	   
	   
	    public String ListAnos(String cpf) {
		   
	        String[] listanos = getByCPF(cpf).split(",");
            StringBuffer registros = new StringBuffer();
	        for (String line : listanos) {
	            if (line.contains("/")) {
	            	registros.append(line + "\n");
	            }
	        }
	    
	        String[] listAnos = registros.toString().split(" ");
            StringBuffer registra = new StringBuffer();
             for (String line : listAnos) {
	            	registra.append(line + "\n");
	        }
	        
            String[] listyear = registra.toString().split("\n");
            StringBuffer registry = new StringBuffer();
            for (String line : listyear) {
            	if(!line.contains("/")) {
 	            	registry.append(line + "\n");
            	}
 	        }
	       return registry.toString();
	    }
	    
	    
	   
	
	   
}
