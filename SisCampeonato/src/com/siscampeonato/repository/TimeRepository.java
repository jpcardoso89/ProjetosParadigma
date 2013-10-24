package com.siscampeonato.repository;

import java.util.List;

import com.siscampeonato.entidades.Time;

public interface TimeRepository {
	
	public List<Time> listarTodos();
	public void guardar(Time time);
	public void excluir(Time time);
	public void buscarPorCodigo(Integer id);

}
