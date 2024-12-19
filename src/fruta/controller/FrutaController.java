package fruta.controller;

import java.util.ArrayList;
import fruta.model.Fruta;
import fruta.repository.FrutaRepository;

public class FrutaController implements FrutaRepository {

	private ArrayList<Fruta> listaFrutas = new ArrayList<Fruta>();
	int numero = 0;

	@Override
	public void cadastrar(Fruta fruta) {
		try {
			for (Fruta f : listaFrutas) {
				if (f.getNome().equalsIgnoreCase(fruta.getNome())) {
					System.out.println("\nErro ao cadastrar fruta: A fruta " + fruta.getNome() + " já foi cadastrada.");
					return; 
				}
			}
			listaFrutas.add(fruta);
			System.out.println("\nFruta adicionada: " + fruta.getNome());
			if (fruta.getPreco() <= 0) {
				System.out.println("Erro ao cadastrar fruta: O preço da fruta deve ser maior que zero.");
				return;
			}

		} catch (Exception e) {
			System.out.println("Erro inesperado ao cadastrar fruta: " + e.getMessage());
		}
	}

	@Override
	public void atualizar(String nome, Fruta frutaAtualizada) {
		try {
			var buscaFruta = buscarNaCollection(nome);

			if (buscaFruta != null) {
				listaFrutas.set(listaFrutas.indexOf(buscaFruta), frutaAtualizada);
				System.out.println("\nA fruta " + nome + " foi atualizada com sucesso");
			} else {
				System.out.println("\nA fruta " + nome + " não foi encontrada");
			}
		} catch (Exception e) {
			System.out.println("Erro ao atualizar a fruta: " + e.getMessage());
		}
	}

	@Override
	public void deletar(String nome) {
		try {
			var fruta = buscarNaCollection(nome);

			if (fruta != null) {
				if (listaFrutas.remove(fruta)) {
					System.out.println("\nA fruta " + nome + " foi deletada com sucesso!");
				} else {
					System.out.println("\nA fruta " + nome + " não foi encontrada!");
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao deletar a fruta: " + e.getMessage());
		}
	}

	@Override
	public void listarTodas() {
		try {
			if (listaFrutas.isEmpty()) {
				System.out.println("Nenhuma fruta disponível.");
			} else {
				listaFrutas.forEach(Fruta::mostrarDetalhes);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar frutas: " + e.getMessage());
		}
	}

	public Fruta buscarNaCollection(String nome) {
		for (var fruta : listaFrutas) {
			if (fruta.getNome().equalsIgnoreCase(nome)) {
				return fruta;
			}
		}
		return null;
	}
}
