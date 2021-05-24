package list;
import controllers.historicoController;
import models.Historico;
import services.TXTService;
import list.List;

public class Ordenação {
	
	TXTService<Historico> txthistorico = new TXTService<>("historico.txt");
	historicoController historyController = new historicoController(txthistorico);
	
	//--Pivo: Data de Agendamento Atual.
	
	public void QuickSort(int pivo) {
	 	
		List<Integer> listanos = new List<Integer>();
		String[] anos = historyController.ListAnos("4444444444444").split("\n");
        for(String line : anos)	{
		  listanos.add(Integer.parseInt(line.trim()));
        }
        System.out.println(listanos.toString());
	}
	
	
}
