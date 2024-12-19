package fruta.model;

public abstract class Fruta {
	private String nome;
	private int quantidade;
	private float preco;

	// Construtor
	public Fruta(String nome, int quantidade, float preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	// Método abstrato
	public abstract void mostrarDetalhes();
}
