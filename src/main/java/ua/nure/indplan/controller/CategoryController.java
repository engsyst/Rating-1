package ua.nure.indplan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Category;
import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.CategoryTypeService;
import ua.nure.indplan.validation.CategoryValidator;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

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
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return  "categoryAll";
    }

    void fillModel(Model model, Category category) {
    	List<CategoryType> types = new ArrayList<>();
    	types.add(new CategoryType());
    	types.addAll(categoryTypeService.getAll());
    	model.addAttribute("category", category);
    	model.addAttribute("types",types);
    	
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String categoryAddPage(Model model) {
    	fillModel(model, new Category());
        return "categoryAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String categoryAdd(@Valid @ModelAttribute Category category, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            fillModel(model, category);
            return "categoryAdd";
        } else {
            categoryService.addCategory(category);
            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("category.added", null, LocaleContextHolder.getLocale()));
            return "redirect:/category/save";
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String categoryUpdatePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
    	Category category = categoryService.getById(id);
    	fillModel(model, category);
    	return "categoryEdit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String categoryUpdate(@Valid @ModelAttribute Category category, BindingResult bindingResult,
    		RedirectAttributes redirectAttributes, Model model) {
    	if (bindingResult.hasErrors()) {
    		fillModel(model, category);
    		return "categoryEdit";
    	} else {
    		categoryService.updateCategory(category);
    		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("category.updated", null, LocaleContextHolder.getLocale()));
    		return "redirect:/category/getAll";
    	}
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String categoryDeletePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
    	Category category = categoryService.getById(id);
    	model.addAttribute(category);
    	return "categoryDetail";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String categoryDelete(@RequestParam(value = "id", required = true) Integer id) {
		Category category = categoryService.getById(id);
		categoryService.deleteCategory(category);
		return "redirect:/category/getAll";
	}
}
