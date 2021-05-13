package controllers;
import models.Client;
import models.Temas;
import services.TXTService;

import javax.swing.JOptionPane;

import list.List;

public class TemasController {
	 private TXTService<String> txtService;
	
	
	List<String> listatemas = new List<String>();
	//TXTService txt = new TXTService();
	
	public TemasController(TXTService<String> txts) {
        this.txtService = txts;
    }
	
	public void createTemas(Temas tema) {
	      txtService.createTemas(tema);
	       
	}
	
	public List<Temas> readTemas() {
        List<String> temasTXT = txtService.read();
        List<Temas> temas = new List<>();

        String[] temasss = temas.toString().split("\n");
        for (String line : temasss) {
            String[] data = line.split(",");
            String tema = data[0];
            String descricao = data[1];
            String valor = data[2];

            Temas temass = new Temas(tema, descricao, valor);
            temas.add(temass);
        }

        return temas;
    }
	
    public Temas getByNome(String nome) throws Exception {
        List<Temas> temasList = readTemas();
        String[] temas = temasList.toString().split("\n");
        Temas tema;

        for (String line : temas) {
            if (line.contains(nome)) {
                String[] data = line.split(",");
                String temaa = data[0];
                String descricao = data[1];
                String valor = data[2];
                tema = new Temas(temaa, descricao, valor);
                return tema;
            }
        }

        throw new Exception("Tema não encontrado");
    }
    
    public void deleteTemas(String nome) {
        try {
            Temas tema = getByNome(nome);
            txtService.deleteTemas(tema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  	public boolean consultatema(String nome, List<String> list) {
   		if (list.toString().contains(nome)){
   			return true;
   		}
   		else {
   		   return false;
   		}
   	}
	
//	public List<String> adicionar(String nometema, String descricao, String valor) {
//      Temas temas = new Temas(nometema, descricao, valor);
//      temas.setNome(nometema);
//      temas.setDescricao(descricao);
//      temas.setValue(valor);   
//      listatemas.add(temas.toString());
//      return listatemas;
//	}
    
	public void salvartxt() { 	
		
		 System.out.println(listatemas.toString());
    	 //Salvar Lista em TXT
	}

	
}
