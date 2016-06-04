package net.ua.controller;

import net.ua.entity.Category;
import net.ua.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return  "categoryAll";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        categories.addAll(categoryService.getAllCategories());
        Category category = new Category();
        category.setParentCategory(new Category());
        model.addAttribute("category", category);
        model.addAttribute("categories",categories);
        return "categoryAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String categoryAdd(@Valid @ModelAttribute Category category, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            String message = "Ошибка при добавлении";
            redirectAttributes.addFlashAttribute("message", message);
            return "activityAdd";
        } else {
            System.out.println("cat: " + category.toString());
            categoryService.addCategory(category);
            String message = "Категория успешно добавлена";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/category/save";
        }
    }
}
