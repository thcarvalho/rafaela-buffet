package controllers;
import models.Agendamentos;
import models.Client;
import models.Desconto;
import models.Temas;
import services.TXTService;

public class DescontoController {
	
	TXTService<Agendamentos> txtagendamento = new TXTService<>("agendamentos.txt");
	AgendamentosController agendamentoscontroller = new AgendamentosController(txtagendamento);
 
}
