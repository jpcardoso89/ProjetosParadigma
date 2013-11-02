package com.siscampeonato.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.repository.CampeonatoRepository;
import com.siscampeonato.util.RepositoriosUtil;

@FacesConverter(forClass=Campeonato.class)
public class CampeonatoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Campeonato retorno = null;
		if(value != null && !value.equals("")){
			CampeonatoRepository campeonatos = RepositoriosUtil.getCampeonatos();
			retorno = campeonatos.buscarPorCodigo(new Integer(value));
			
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer codigo = ((Campeonato) value).getId();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
