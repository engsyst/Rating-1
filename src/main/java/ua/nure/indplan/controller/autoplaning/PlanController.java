package ua.nure.indplan.controller.autoplaning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.nure.indplan.entity.autoplaning.Plan;
import ua.nure.indplan.service.autoplaning.DisciplineAttributeService;
import ua.nure.indplan.service.autoplaning.ExcelParserService;
import ua.nure.indplan.service.autoplaning.PlanService;

import java.io.IOException;

@Controller
@RequestMapping(value = "/autoplaning")
public class PlanController {

    @Autowired
    private ExcelParserService excelParserService;
    @Autowired
    private PlanService planService;
    @Autowired
    private DisciplineAttributeService disciplineAttributeService;

    @RequestMapping
    public String getIndex() {
        return "autoplaning/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loadExcelAndPassToEditing(@RequestParam("planFile") MultipartFile file) throws IOException {
        excelParserService.createAndSavePlanFromMultipartFile(file);
        return "redirect:autoplaning";
    }

    @RequestMapping(value = "/plan", method = RequestMethod.GET)
    public String activityAddPage(@RequestParam(value = "id", required = true) Integer id, Model model) {
        model.addAttribute("plan", planService.getPlanById(id));
        model.addAttribute("ds", disciplineAttributeService.findAll());
        return "autoplaning/plan";
    }

}
