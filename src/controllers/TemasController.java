package controllers;
import models.Client;
import models.Temas;
import services.TXTService;
import javax.swing.JOptionPane;

import list.List;

public class TemasController {
    private TXTService<Temas> txtService;

    public TemasController(TXTService<Temas> txtTemas) {
        this.txtService = txtTemas;
    }

	public void add(Temas tema) {
		  if(consultaTemas(tema.getNome(), txtService.read())) {
	    	  JOptionPane.showMessageDialog(null,"Tema já existente!");  
	       }
	       else {
	    	 txtService.create(tema);;
	       }
	       
	  }
	 
		public boolean consultaTemas(String tema, List<String> list) {
	   		return list.toString().contains(tema);
	   	}
       
    

    public List<Temas> read() {
        List<String> clientTXT = txtService.read();
        List<Temas> themes = new List<>();

        String[] lines = clientTXT.toString().split("\n");
        for (String line : lines) {
            themes.add(stringToTheme(line));
        }

        return themes;
    }

    public void delete(String name) {
        try {
        	Temas temas = getByName(name);
            txtService.delete(temas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Temas stringToTheme(String line){
        if (line.isEmpty()) return new Temas();
        String[] data = line.split(",");
        String name = data[0];
        String description = data[1];
        String value = data[2];
        return new Temas(name, description, value);
    }
    
    public Temas getByName(String nome) throws Exception {
        List<Temas> temaList = read();
        String[] tema = temaList.toString().split("\n");

        for (String line : tema) {
            if (line.contains(nome)) {
                return stringToTheme(line);
            }
        }

        throw new Exception("Tema não encontrado!");
    }
    
    
}
