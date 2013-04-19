package edu.makoto.multilingual.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.makoto.multilingual.dao.BaseDAO;
import edu.makoto.multilingual.domain.Properties;

@Service
public class LanguageService {
	
	@Autowired
	private BaseDAO baseDAO;
	 
	//Hibernate return a list but java.util.Properties only recive 
	public HashMap<String, String>findPropertiesByLanguage(String language) {
		
		List<Properties> list = baseDAO.find("from Properties p where str(p.language) = ?",language);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (Properties propertiesLanguage : list) {
			map.put(propertiesLanguage.getKey(), propertiesLanguage.getValue());
		}		
		return map;
	}

	
}
