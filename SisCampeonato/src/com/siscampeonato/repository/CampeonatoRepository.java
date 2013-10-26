package com.siscampeonato.repository;

import java.util.List;

import com.siscampeonato.entidades.Campeonato;

public interface CampeonatoRepository {

	public List<Campeonato> listarTodos();
	public void guardar(Campeonato campeonato);
	public void excluir(Campeonato ampeonato);
	public Campeonato buscarPorCodigo(Integer id);

}
