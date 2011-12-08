package com.zanclus.opennms.data.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import android.util.Log;

public class DateConverter implements Converter<Long> {

	private DateTimeFormatter getFormatter(String dateTimeString) {
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder() ;
		builder.appendYear(4, 4)
				.appendLiteral("-")
				.appendMonthOfYear(2)
				.appendLiteral("-")
				.appendDayOfMonth(2)
				.appendLiteral("T")
				.appendHourOfDay(2)
				.appendLiteral(":")
				.appendMinuteOfHour(2)
				.appendLiteral(":")
				.appendSecondOfMinute(2) ;
		if (dateTimeString!=null) {
			if (dateTimeString.contains(".")) {
				Log.d("DateConverter","Date/Time has Microseconds") ;
				builder.appendLiteral(".").appendMillisOfSecond(3) ;
			}

			if (dateTimeString.contains("Z")) {
				Log.d("DateConverter","Date/Time has a 'Z' literal.") ;
				builder.appendLiteral("Z") ;
			}

			if (dateTimeString.contains("+")) {
				Log.d("DateConverter","Date/Time has '+' UTC offset") ;
				builder.appendTimeZoneOffset("+00:00", true, 2, 2) ;
			}
		}
		return builder.toFormatter() ;
	}

	public Long read (InputNode node) {
		String dateTimeStr = null ;
		try {
			dateTimeStr = node.getValue() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTime dt = getFormatter(dateTimeStr).parseDateTime(dateTimeStr) ;

		return new Long(dt.getMillis()) ;
		
	}

	public void write(OutputNode node, Long value) {
		Date dateVal = new Date(value) ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") ;
		node.setValue(df.format(dateVal)) ;
	}
}
