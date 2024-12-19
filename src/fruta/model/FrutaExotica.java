package fruta.model;

public class FrutaExotica extends Fruta {

	private String origem;

	public FrutaExotica(String nome, int quantidade, float preco, String origem) {
		super(nome, quantidade, preco);
		this.origem = origem;

	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Override
	public void mostrarDetalhes() {
		System.out.println("Nome: " + getNome());
		System.out.println("Quantidade: " + getQuantidade());
		System.out.println("Preço: R$" + getPreco());
		System.out.println("Origem: " + origem);
	}
}
