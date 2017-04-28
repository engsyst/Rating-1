package ua.nure.indplan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Category;
import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.CategoryTypeService;
import ua.nure.indplan.validation.CategoryValidator;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryTypeService categoryTypeService;
    
    @Autowired
	private CategoryValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
    
    @Autowired
    MessageSource messageSource;
	
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return  "categoryAll";
    }

    void fillModel(Model model, Category category) {
    	List<CategoryType> types = new ArrayList<>();
    	types.add(new CategoryType());
    	types.addAll(categoryTypeService.getAll());
    	model.addAttribute("category", category);
    	logger.trace("setModelAttr:category", category);
    	model.addAttribute("types",types);
    	logger.trace("setModelAttr:types", types);
    	
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
    	fillModel(model, new Category());
        return "categoryAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String categoryAdd(@Valid @ModelAttribute Category category, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) {
    	logger.debug("save:POST:categorySave");
        if (bindingResult.hasErrors()) {
        	logger.debug(bindingResult.toString());
            fillModel(model, category);
            return "categoryAdd";
        } else {
            categoryService.addCategory(category);
            logger.trace("addCategory", category);
//            String message = "Категория успешно добавлена";
//            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("category.added", null, LocaleContextHolder.getLocale()));
            return "redirect:/category/save";
        }
    }
}
