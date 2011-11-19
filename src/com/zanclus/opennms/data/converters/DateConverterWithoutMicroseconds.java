package com.zanclus.opennms.data.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class DateConverterWithoutMicroseconds implements Converter<Long> {

	public Long read (InputNode node) {
		String value = null ;
		try {
			value = node.getValue() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") ;
		try {
			Date dateVal = df.parse(value) ;
			return dateVal.getTime() ;
		} catch (ParseException pe) {
			System.out.println("Encountered a parse exception for date string '"+value+"'") ;
			pe.printStackTrace() ;
		}

		return 0L ;
	}

	public void write(OutputNode node, Long value) {
		Date dateVal = new Date(value) ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") ;
		node.setValue(df.format(dateVal)) ;
	}
}
