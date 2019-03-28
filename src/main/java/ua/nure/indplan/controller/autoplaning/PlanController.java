package ua.nure.indplan.controller.autoplaning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.nure.indplan.service.autoplaning.ExcelParserService;

import java.io.IOException;

@Controller
@RequestMapping(value = "/autoplaning")
public class PlanController {

    @Autowired
    private ExcelParserService excelParserService;

    @RequestMapping
    public String getIndex() {
        return "autoplaning/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loadExcelAndPassToEditing(@RequestParam("planFile") MultipartFile file) throws IOException {
        excelParserService.createAndSavePlanFromMultipartFile(file);
        return "redirect:autoplaning";

    }

}
