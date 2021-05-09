package controllers;
import models.Temas;
import services.TXTService;
import list.List;

public class TemasController {
    private TXTService<Temas> txtService;

    public TemasController(TXTService<Temas> txtTemas) {
        this.txtService = txtTemas;
    }

	public void add(Temas tema) {
        txtService.create(tema);
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

    public void delete(Temas tema) {
        try {
            txtService.delete(tema);
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
}
