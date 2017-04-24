package ua.nure.indplan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Category;
import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.CategoryTypeService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryTypeService categoryTypeService;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return  "categoryAll";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
        List<CategoryType> types = new ArrayList<>();
        types.add(new CategoryType());
        types.addAll(categoryTypeService.getAll());
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("types",types);
        return "categoryAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String categoryAdd(@Valid @ModelAttribute Category category, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
    	logger.info("save:POST:categorySave");
        if (bindingResult.hasErrors()) {
        	logger.error(bindingResult.toString());
            /*String message = "Ошибка при добавлении";
            redirectAttributes.addFlashAttribute("message", message);*/
            return "categoryAdd";
        } else {
            System.out.println("cat: " + category.toString());
            categoryService.addCategory(category);
            String message = "Категория успешно добавлена";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/category/save";
        }
    }
}
