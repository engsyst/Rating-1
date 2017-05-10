package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Category;
import ua.nure.indplan.service.CategoryService;

@Service
public class CategoryFormatter implements Formatter<Category> {
    @Autowired
    CategoryService ctService;   //Service -> DB

	@Override
	public String print(Category object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public Category parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);
		Category ct = id == 0 ? new Category() : this.ctService.getById(id); //return Category object form DB;
        return ct;
	}

}
