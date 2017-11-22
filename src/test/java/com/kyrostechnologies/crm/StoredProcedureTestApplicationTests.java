package com.kyrostechnologies.crm;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StoredProcedureTestApplicationTests {
	@SuppressWarnings("unused")
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private EntityManager entityManager;

	@Test
	public void insertLanguageTest() {
		String LanguageName="Year";
		String LanguageCultureName="Year";
		StoredProcedureQuery sp=entityManager.createNamedStoredProcedureQuery("`Settings.Language_InsertLanguage`");
			sp.setParameter("LanguageCultureName", LanguageCultureName);
			sp.setParameter("LanguageName", LanguageName);
			//boolean value=sp.execute();
			int value=sp.executeUpdate();
			System.out.println("TestResult : "+value);
			Assert.assertEquals(1, value);
	}

}
