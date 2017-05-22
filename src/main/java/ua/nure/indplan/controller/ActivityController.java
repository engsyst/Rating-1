package ua.nure.indplan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Activity;
import ua.nure.indplan.service.ActivityService;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {


    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<Activity> activities = activityService.getAllActivities();
        model.addAttribute("activities", activities);
        return "activityAll";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String activityAddPage(Model model) {
   
        model.addAttribute("activity", new Activity());
        return "activityAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String activityAdd(@Valid @ModelAttribute Activity activity, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            String message = "Ошибка при добавлении";
            redirectAttributes.addFlashAttribute("message", message);
            return "activityAdd";
        } else {

            activityService.addActivity(activity);
            String message = "Мероприятие успешно добавлено";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/activity/save";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase) {

        Activity activity = activityService.getById(id);
        activityService.deleteActivity(activity);
        return "redirect:/activity/getAll";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateActivityPage(@RequestParam(value = "id", required = true) Integer id,
                                 Model model) {

        Activity activity = activityService.getById(id);
        model.addAttribute("activity", activity);
        return "activityEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute Activity activity) {
        activityService.updateActivity(activity);
        return "redirect:/activity/getAll";
    }
}
