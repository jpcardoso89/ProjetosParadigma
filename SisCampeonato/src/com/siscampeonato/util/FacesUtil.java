package com.siscampeonato.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/*CLASSE DESTINADA APENAS A MANDAR MENSAGENS*/
public class FacesUtil {
	
	public static void adicionarMessage(Severity severity, String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, msg));
	}

//	Metodo para recuperar a session criada no Filtro
//  Passando com parametro o palavra session definida na classe HibernateSessionFilter para recuperar a session
	public static Object getRequestAttribute(String name){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		return request.getAttribute(name);
	}

}
