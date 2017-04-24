package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.service.CategoryTypeService;

@Service
public class CategoryTypeFormatter implements Formatter<CategoryType> {
    @Autowired
    CategoryTypeService ctService;   //Service -> DB

	@Override
	public String print(CategoryType object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public CategoryType parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);
		CategoryType ct = id == 0 ? new CategoryType() : this.ctService.getById(id); //return CategoryType object form DB;
        return ct;
	}

}
