package com.siscampeonato.bo;

import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.repository.CampeonatoRepository;

public class CampeonatoBO {
	
	private CampeonatoRepository campeonatos;
	
	public CampeonatoBO(CampeonatoRepository campeonatos) {
		this.campeonatos = campeonatos;
		
	}
	
	public void salvar(Campeonato campeonato) throws RegraNegocioException{
		if (existeCampeonatoSemelhante(campeonato)) {
			throw new RegraNegocioException("Já existe um Campeonato igual a este!");
		}
		
		this.campeonatos.guardar(campeonato);
		
	}
	
	public boolean existeCampeonatoSemelhante(Campeonato campeonato){
		Campeonato campeonatoSemelhante = this.campeonatos.comDadosIguais(campeonato);
		
		return campeonatoSemelhante != null && 
				!campeonatoSemelhante.equals(campeonato);
		
	}
	
	public void excluir(Campeonato campeonato) throws RegraNegocioException{
		
		campeonato = this.campeonatos.buscarPorCodigo(campeonato.getId());
		
		if(campeonato.getTimes().size()> 0){
			throw new RegraNegocioException("Campeonato não pode ser exluir, pois existem times jogando!");
		}
		
		this.campeonatos.excluir(campeonato);
		
	}
	
	

}
