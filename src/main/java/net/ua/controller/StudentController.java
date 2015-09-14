package net.ua.controller;

import net.ua.entity.Group;
import net.ua.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/allGroups", method = RequestMethod.GET)
    public String getAllgroups(Model model) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "groupAll";
    }

    @RequestMapping(value = "/saveGroup")
    public String addGroupPage(Model model) {
        model.addAttribute("group", new Group());
        return "groupAdd";
    }

    @RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
    public String addGroup(@Valid @ModelAttribute Group group,
            RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "groupAdd";
        } else {
            groupService.addGroup(group);
            String message = "Группа успешно добавлена";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/student/saveGroup";
        }
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
    public String deleteGroup(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            Model model, RedirectAttributes redirectAttributes) {
        Group group = groupService.getById(id);
        groupService.deleteGroup(group);
        redirectAttributes.addFlashAttribute("message", "Запись успешно удалена");
        return "redirect:/student/allGroups";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.GET)
    public String updateGroupPage(@RequestParam(value = "id", required = true) Integer id,
            Model model) {
        Group group = groupService.getById(id);
        model.addAttribute("group", group);
        return "groupEdit";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
    public String updateGroup(@ModelAttribute Group group) {
        groupService.updateGroup(group);
        return "redirect:/student/allGroups";
    }
}
