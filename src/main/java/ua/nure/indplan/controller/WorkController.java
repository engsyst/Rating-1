package ua.nure.indplan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.entity.Work;
import ua.nure.indplan.entity.WorkType;
import ua.nure.indplan.service.CategoryTypeService;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.StorageService;
import ua.nure.indplan.service.StudentService;
import ua.nure.indplan.service.WorkService;
import ua.nure.indplan.service.WorkTypeService;
import ua.nure.indplan.service.realization.StudentAdapter;
import ua.nure.indplan.validation.WorkValidator;

@Controller
@RequestMapping(value = "/work")
public class WorkController {

 
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    StudentAdapter studentAdapter;
    
    @Autowired
    CategoryTypeService categoryTypeService;
    
    @Autowired
    WorkService workService;

    @Autowired
    WorkTypeService workTypeService;
    
//    @Autowired
//	private WorkValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new WorkValidator());
	}
    
    @Autowired
    MessageSource messageSource;
	
    private final StorageService storageService;

    @Autowired
    public WorkController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Work> works = workService.getAll();
        List<Employee> employees = employeeService.getAll();
        List<WorkType> types = workTypeService.getAll();
        model.addAttribute("works", works);
        model.addAttribute("types", types);
        model.addAttribute("employees", employees);
        return  "workAll";
    }

    void fillModel(Work work, Model model) {
    	List<WorkType> types = new ArrayList<>();
//    	types.add(new WorkType());
    	types.addAll(workTypeService.getAll());
    	model.addAttribute("types",types);
    	
    	List<Employee> employees = new ArrayList<>();
    	employees.addAll(employeeService.getAll());
    	model.addAttribute("employees",employees);
    	
    	List<CategoryType> categories = new ArrayList<>();
    	categories.addAll(categoryTypeService.getAll());
    	model.addAttribute("categories",categories);
    	
    	model.addAttribute("doc", work.getDoc());
    	
//    	List<Student> students = Collections.emptyList();
//    	students.addAll(work.getStudents());
//    	model.addAttribute("students", studentAdapter.get(students));
    	model.addAttribute("work", work);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String workAddPage(Model model) {
    	Work work = new Work();
    	fillModel(work, model);
        return "workAdd";
    }
    
    private static final String PREFIX_DELIMITER = "_.";

    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public String workAdd(
			@RequestParam Date date, 
			@RequestParam MultipartFile file, 
			@Valid @ModelAttribute Work work,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes, 
			Model model
			) {
    	if (date == null) {
    		bindingResult.rejectValue("date", "work.date.hint", "date can't be null");
    	}
        if (bindingResult.hasErrors()) {
            fillModel(work, model);
            return "workAdd";
        } else {
        	work.setDate(date);
            workService.add(work);
            if (!StringUtils.isEmpty(file.getOriginalFilename())) {
            	String prefix = work.getId() + PREFIX_DELIMITER;
            	storageService.store(file, prefix);
            	work.setDoc(prefix + file.getOriginalFilename());
            	workService.update(work);
            }
            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("work.added", null, LocaleContextHolder.getLocale()));
            return "redirect:/work/save";
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String workUpdatePage(
    		@RequestParam(value = "id", required = true) 
    			Integer id, 
    			Model model) {
    	Work work = workService.getById(id);
        fillModel(work, model);
    	return "workEdit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String workUpdate(
			@RequestParam Date date, 
			@RequestParam MultipartFile file, 
			@Valid @ModelAttribute Work work,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes, 
			Model model
			) {
    	if (date == null) {
    		bindingResult.rejectValue("date", "work.date.hint", "date can't be null");
    	}
    	if (bindingResult.hasErrors()) {
            fillModel(work, model);
    		return "workEdit";
    	} 
		work.setDate(date);
		if (StringUtils.isEmpty(work.getDoc())) {
			work.setDoc(null);
		}
        if (!StringUtils.isEmpty(file.getOriginalFilename())) {
        	String prefix = work.getId() + PREFIX_DELIMITER;
        	String docName = work.getDoc();
        	if (docName != null && !docName.isEmpty()) {
        		storageService.delete(docName);
        	}
        	storageService.store(file, prefix);
        	work.setDoc(prefix + file.getOriginalFilename());
        }
		workService.update(work);
		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("work.updated", null, LocaleContextHolder.getLocale()));
		return "redirect:/work/getAll";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String workDeletePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
    	Work work = workService.getById(id);
    	model.addAttribute(work);
    	return "workDetail";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String workDelete(@RequestParam(value = "id", required = true) Integer id) {
		Work work = workService.getById(id);
		workService.delete(work);
		return "redirect:/work/getAll";
	}
    
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> workDownload(@RequestParam(value = "doc", required = true) String fileName) {
    	Resource file = storageService.loadAsResource(fileName);
    	return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
}
