package com.siscampeonato.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.repository.CampeonatoRepository;

public class CampeonatoDAO implements CampeonatoRepository{
	
	private Session session;
	
	public CampeonatoDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Campeonato> listarTodos() {
		return this.session.createCriteria(Campeonato.class).list();
	}

	@Override
	public void guardar(Campeonato campeonato) {
		this.session.merge(campeonato);
	}

	@Override
	public void excluir(Campeonato campeonato) {
		this.session.delete(campeonato);
	}

	@Override
	public Campeonato buscarPorCodigo(Integer id) {
		return (Campeonato) this.session.get(Campeonato.class,id);
	}

	@Override
	public Campeonato comDadosIguais(Campeonato campeonato) {
		return (Campeonato) this.session.createCriteria(Campeonato.class)
				.add(Restrictions.ilike("nome", campeonato.getNome()))
				.add(Restrictions.eq("qtdRodadas", campeonato.getQtdRodadas()))
				.uniqueResult();
	}

}
