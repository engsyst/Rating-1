package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DateFormatter implements Formatter<Date> {

	@Override
	public String print(Date object, Locale locale) {
		return object != null ? new SimpleDateFormat().format(object) : "";
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		Date d = StringUtils.isEmpty(text) ? new Date() : new SimpleDateFormat("dd-MM-yyyy", new Locale("ru")).parse(text); //return Date object form DB;
        return d;
	}

}
