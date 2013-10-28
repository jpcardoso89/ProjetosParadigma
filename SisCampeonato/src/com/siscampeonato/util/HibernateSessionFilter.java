package com.siscampeonato.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

//Anotação para resgistrar o filtro que fara o Pattern Open Session in View
//Filtro esse que ira intercptar o FaceServlett antes de ser executado.
@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionFilter implements Filter {

//Parametro request representa o scopo de requisição do managedBean
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Session session = HibernateUtil.getSession();
		Transaction trx = null;
		
		try{
			trx = session.beginTransaction();
//			A session é obtida apartir desse método passando a palavra session.
			request.setAttribute("session", session);
			
//		Dá a continuidade ao processo.
			chain.doFilter(request, response);
			trx.commit();
		}catch(Exception e){
			if (trx != null) {
//				Se acontecer algum erro os objetos voltanao seu estado anterior
				trx.rollback();
				
			}
			
		}finally{
			session.close();
		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
