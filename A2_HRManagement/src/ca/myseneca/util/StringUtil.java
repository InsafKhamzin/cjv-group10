package ca.myseneca.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	public static boolean isNullOrEmpty(String str) {
		return str != null && !str.isEmpty() ? false : true;
	}
	
	public static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public static boolean tryParseFloat(String value) {  
	     try {  
	         Float.parseFloat(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public static boolean tryParseDate(String value){
		try {
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
