package edu.makoto.multilingual;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import org.zkoss.spring.SpringUtil;
import org.zkoss.util.resource.LabelLocator2;

import edu.makoto.multilingual.service.LanguageService;

public class CustomLabelLoader implements LabelLocator2 {
	
	private LanguageService serviceLocator;	
	
    private String _field;
    
    private String language;
    
    public CustomLabelLoader(String _field, String language) {
        this._field = _field;
        this.language = language;     
    }
    
    public InputStream locate(Locale locale) {
    	initSpring();
    	InputStream is=null;
    	
    	//This condition is ver y important DON'T FORGET 
    	//When zk try to load 3 diferent locales for example: en,EN, en_US
    	//We have to compare only with our language registered (from BD)
    	
    	if(locale!=null && locale.toString().equals(language)){
    		is = getStreamProperties();
    	}
    	
        return is;
    }

    //This is a method that transform Properties to InputStream.
    public InputStream getStreamProperties(){
    	Properties prop = new Properties();
    	
    	//Call to service and getTheproperties in hashmap
    	prop.putAll(serviceLocator.findPropertiesByLanguage(language));
    	
    	ByteArrayOutputStream output = new ByteArrayOutputStream();    	
    	try {
    		
			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
    	
    	return input;
    }
    
    //Depending the encoding you use    
    public String getCharset() {
        return "UTF-8"; 
    }
    
    //Get the SpringBean from the context
    public void initSpring(){
    	serviceLocator = (LanguageService) SpringUtil.getBean("languageService");;
    
    }
    
}
