package controllers;
import models.Temas;
import services.TXTService;
import list.List;

public class TemasController {
	
	
	List<String> listatemas = new List<String>();
	//TXTService txt = new TXTService();
	
	public List<String> adicionar(String nometema, String descricao, String valor) {
      Temas temas = new Temas(nometema, descricao, valor);
      temas.setNome(nometema);
      temas.setDescricao(descricao);
      temas.setValue(valor);   
      listatemas.add(temas.toString());
      return listatemas;
	}
    
	public void salvartxt() { 	
		
		 System.out.println(listatemas.toString());
    	 //Salvar Lista em TXT
	}

	
}
