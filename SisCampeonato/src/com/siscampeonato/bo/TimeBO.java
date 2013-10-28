package com.siscampeonato.bo;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;

public class TimeBO {
	
	private TimeRepository times;
	
	public TimeBO(TimeRepository times) {
		this.times = times;
	}
	
	public void salvar(Time time) throws RegraNegocioException {
		if (existeTimeSemelhante(time)) {
			throw new RegraNegocioException("Já existe um Time igual a este!");

		}
		
		this.times.guardar(time);
		
	}
	
	public boolean existeTimeSemelhante(Time time){
		Time timeSemelhante = this.times.comDadosIguais(time);
		
		return timeSemelhante != null && 
				!timeSemelhante.equals(timeSemelhante);
	}
	
	public void excluir(Time time){
		this.times.excluir(time);
	}

}
