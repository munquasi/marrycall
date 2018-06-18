package com.muka.marry.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args)throws Exception {  
	    
	   
	} 
	
	public static Date convertStringToDate(String stringDate) throws ParseException
	{
		 //String start_dt = "1992-01-01";

		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		    Date date = (Date) dateFormat.parse(stringDate);
		   return date;
	}

}
