package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DateFormatter implements Formatter<Date> {

	@Autowired
	MessageSource source;
	
	@Override
	public String print(Date object, Locale locale) {
		return object != null ? new SimpleDateFormat().format(object) : "";
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		Date d = StringUtils.isEmpty(text) ? new Date()
				: new SimpleDateFormat(source.getMessage("date.pattern.java", null, LocaleContextHolder.getLocale()))
						.parse(text); // return Date object form DB;
		return d;
	}
}
