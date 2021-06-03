package controllers;
import controllers.ClientController;
import javax.swing.JOptionPane;
import list.List;
import list.Ordena��o;
import models.Agendar;
import models.Historico;
import models.Client;
import services.TXTService;

public class AgendamentosController {
	
	TXTService<Historico> txthistorico = new TXTService<>("historico.txt");
	historicoController historyController = new historicoController(txthistorico);
	TXTService<Client> txtclient = new TXTService<>("client.txt");
	ClientController client = new ClientController(txtclient);
	Ordena��o algoritmo = new Ordena��o();
	
	public boolean desconto(String cpf) {
      int reservaAtual = 2021;
	 //Puxa Hist�ricos de Aluguel por Cliente
	  String[] anos = historyController.ListAnos(cpf).split("\n");
	  int vet[] = new int[anos.length];
      for(int i = 0; i< anos.length; i++)	{
	    vet[i] = Integer.parseInt(anos[i].trim());
      }  
      //Verifica se a quantidade de alugueis se enquadra na regra de neg�cio (2 ou mais).
       if(vet.length >= 2) {
    	//Ordena seus alugueis do mais antigo para o mais recente.
        algoritmo.quickSort(vet, 0, vet.length-1);
        //Compara se o mais antigo se enquadra na regra de n�g�cio (No m�nimo 2 anos).
        if(vet[0] <= reservaAtual-2) {
         System.out.println(vet[0]);
         return true;
        }
       }
        return false;
      }  
	
	public AgendamentosController(TXTService<Agendar> txts) {
        this.txtService = txts;
    }
	
	 private TXTService<Agendar> txtService;
	  public void create(Agendar agendamentos) {
		  if(consultaagendamentos(agendamentos.getData(), agendamentos.getTema(), txtService.read())) {
	    	  JOptionPane.showMessageDialog(null,"O mesmo Tema s� pode ser Agendado uma vez por Dia!");  
	       }
	       else if(desconto(agendamentos.getClient())){
	    	 System.out.println("entrei aqui");
	       }
	       else{
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
