package com.siscampeonato.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.siscampeonato.dao.CampeonatoDAO;
import com.siscampeonato.dao.TimeDAO;
import com.siscampeonato.repository.CampeonatoRepository;

public class RepositoriosUtil implements Serializable{

	private static final long serialVersionUID = -3545602835153974064L;

	@SuppressWarnings("unused")
	public static CampeonatoRepository getCampeonatos(){
		return new CampeonatoDAO(getSession());
	}
	
	@SuppressWarnings("unused")
	public static TimeDAO getTimes(){
		return new TimeDAO(getSession());
	}
	
	public static Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}


}
