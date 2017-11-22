package com.kyrostechnologies.crm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class LanguageController  {
	@Autowired
	private LanguageImplementation dataTier;
		@RequestMapping(method=RequestMethod.POST,value="/language")
		
	public    @ResponseBody void insertLanguageNext(@RequestBody LanguageModel model) {
		System.out.println("API input : "+model.getLanguageCultureName()+" / /"+model.getLanguageName());
		//return model.getLanguageName();
		dataTier.storedProcCall(model);
	}
	
	
}

