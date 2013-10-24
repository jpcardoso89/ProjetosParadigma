package com.siscampeonato.dao;

import java.util.List;

import org.hibernate.Session;

import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.repository.CampeonatoRepository;

public class CampeonatoDAO implements CampeonatoRepository{
	
	private Session session;
	
	public CampeonatoDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public List<Campeonato> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Campeonato campeonato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Campeonato ampeonato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorCodigo(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
