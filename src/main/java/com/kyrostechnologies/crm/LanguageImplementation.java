package com.kyrostechnologies.crm;

import java.sql.CallableStatement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
@Component
public class LanguageImplementation implements LanguageRepository{
	@PersistenceContext
    private EntityManager em;
	@Override
	public void storedProcCall(LanguageModel languageModel) {
		System.out.println("Language Model Impl : "+languageModel.getLanguageCultureName()+" / / "+languageModel.getLanguageName());
		Session session=getSession();
		session.doWork(connection-> {
			CallableStatement callableStatement=null;
			try {
				callableStatement=connection.prepareCall("{CALL `Settings.Language_InsertLanguage`(?,?)}");
				callableStatement.setString(1, languageModel.getLanguageCultureName());
				callableStatement.setString(2, languageModel.getLanguageName());
				callableStatement.execute();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(callableStatement!=null) {
					try {
						callableStatement.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} );
		
	}
	private Session getSession() {
        return em.unwrap(org.hibernate.Session.class);
    }
}
