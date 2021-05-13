package models;

public class Temas {

	private String nome;
	private String descricao;;
	private String value;

	public Temas(String tema, String descricao, String value) {
		this.nome = tema;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return nome + "," + descricao + "," + value;
	}

}
