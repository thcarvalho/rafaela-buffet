package controllers;
import controllers.ClientController;
import javax.swing.JOptionPane;
import list.List;
import list.Ordenação;
import models.Agendar;
import models.Historico;
import models.Client;
import services.TXTService;

public class AgendamentosController {
	
	TXTService<Historico> txthistorico = new TXTService<>("historico.txt");
	historicoController historyController = new historicoController(txthistorico);
	TXTService<Client> txtclient = new TXTService<>("client.txt");
	ClientController client = new ClientController(txtclient);
	Ordenação algoritmo = new Ordenação();
	
	public boolean desconto(String cpf) {
      int reservaAtual = 2021;
	 //Puxa Históricos de Aluguel por Cliente
	  String[] anos = historyController.ListAnos(cpf).split("\n");
	  int vet[] = new int[anos.length];
      for(int i = 0; i< anos.length; i++)	{
	    vet[i] = Integer.parseInt(anos[i].trim());
      }  
      //Verifica se a quantidade de alugueis se enquadra na regra de negócio (2 ou mais).
       if(vet.length >= 2) {
    	//Ordena seus alugueis do mais antigo para o mais recente.
        algoritmo.quickSort(vet, 0, vet.length-1);
        //Compara se o mais antigo se enquadra na regra de négócio (No mínimo 2 anos).
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
	    	  JOptionPane.showMessageDialog(null,"O mesmo Tema só pode ser Agendado uma vez por Dia!");  
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
