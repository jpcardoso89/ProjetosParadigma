package com.siscampeonato.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;
import com.siscampeonato.util.RepositoriosUtil;

@FacesConverter(value="TimeConversor")
public class TimeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Time retorno = null;
		if(value != null && !value.equals("")){
			TimeRepository times = RepositoriosUtil.getTimes();
			retorno = times.buscarPorCodigo(new Integer(value));
			
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer codigo = ((Time) value).getId();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
