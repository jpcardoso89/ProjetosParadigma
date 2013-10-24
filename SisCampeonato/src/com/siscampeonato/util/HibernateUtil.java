package com.siscampeonato.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/*Classe que faz a conexão com o banco via Hibernate*/

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			/*Pegando as configurações do arquivo hibernate.cfg.xml*/
			Configuration configuration = new Configuration();
			configuration.configure();
			
			/*Aplicando as configurações as conexão*/
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
			
			/*Criando a sessão*/
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
			
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
}

