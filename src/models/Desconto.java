package models;

public class Desconto {
	private int anoDesc;
	private int desconto;
	private int minAlugueis;
	
	public Desconto(int anoDesc, int desconto, int minAlugueis) {
		super();
		this.anoDesc = anoDesc;
		this.desconto = desconto;
		this.minAlugueis = minAlugueis;
	}
	
	public int getAnoDesc() {
		return anoDesc;
	}
	public void setAnoDesc(int anoDesc) {
		this.anoDesc = anoDesc;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public int getMinAlugueis() {
		return minAlugueis;
	}
	public void setMinAlugueis(int minAlugueis) {
		this.minAlugueis = minAlugueis;
	}
	
	
	

}
