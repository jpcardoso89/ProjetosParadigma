package com.siscampeonato.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campeonato implements Serializable{

	private static final long serialVersionUID = -4997391991924732016L;
	private Integer id;
	private String nome;
	// Sera obtida apartir da quantidade de time no campeonato
	private Integer qtdRodadas;
	
	private List<Time> times = new ArrayList<Time>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Integer getQtdRodadas() {
		return qtdRodadas;
	}

	public void setQtdRodadas(Integer qtdRodadas) {
		this.qtdRodadas = qtdRodadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}