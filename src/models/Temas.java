package models;

public class Temas {

	private String nome;
	private String descricao;;
	private int value;

	public Temas(String nome, String descricao, int value) {
		this.nome = nome;
		this.descricao = descricao;
		this.value = value;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return nome + "," + descricao + "," + value;
	}

}
