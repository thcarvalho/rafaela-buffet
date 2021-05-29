package controllers;
import controllers.historicoController;
import models.Historico;
import services.TXTService;
import list.Ordena��o;
public class DescontoController {
	
	TXTService<Historico> txthistorico = new TXTService<>("historico.txt");
	historicoController historyController = new historicoController(txthistorico);
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
  }
	

