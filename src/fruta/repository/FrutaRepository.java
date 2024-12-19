package fruta.repository;

import fruta.model.Fruta;

public interface FrutaRepository {

	// CRUD da Fruta

	public void cadastrar(Fruta fruta);

	public void atualizar(Fruta fruta);

	public void deletar(String nome);

	public void listarTodas();
}
