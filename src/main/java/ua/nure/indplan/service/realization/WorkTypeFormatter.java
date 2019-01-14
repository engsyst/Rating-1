package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.WorkType;
import ua.nure.indplan.service.WorkTypeService;

@Service
public class WorkTypeFormatter implements Formatter<WorkType> {
    @Autowired
    WorkTypeService wtService;   //Service -> DB

	@Override
	public String print(WorkType object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public WorkType parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);

		// The object should be returned from DB;
		return id == 0 ? new WorkType() : this.wtService.getById(id); 
	}

}
