package edu.makoto.multilingual;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.zkoss.text.DateFormatInfo;

public class CustomFormatInfo implements DateFormatInfo{
	
	//Default the date format is dd/MM/yy the year is only with 2 digits
	//if you want to transform "yy"  to "yyyy" use this method.
	//Is was a requeriment for my company maybe it help you xD !.
	public String getDateFormat(int style, Locale locale) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);		
	    SimpleDateFormat simple = (SimpleDateFormat) dateFormat;	    
	    String pattern = simple.toPattern().replaceAll("\\byy\\b", "yyyy");	    
		return pattern;
	}

	public String getTimeFormat(int style, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	} 

	public String getDateTimeFormat(int dateStyle, int timeStyle, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

}
