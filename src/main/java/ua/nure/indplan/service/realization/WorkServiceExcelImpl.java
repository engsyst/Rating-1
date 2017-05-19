package ua.nure.indplan.service.realization;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Category;
import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.entity.Work;
import ua.nure.indplan.entity.WorkType;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.WorkService;
import ua.nure.indplan.service.WorkServiceExcel;
import ua.nure.indplan.service.WorkTypeService;

@Service
public class WorkServiceExcelImpl implements WorkServiceExcel{
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	WorkTypeService workTypeService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	WorkService workService;
	
	public void addWorksExel(InputStream input){
		
		List<Category> categoryList = categoryService.getAll();
		List<WorkType> workTypeList = workTypeService.getAll();
		List<Employee> employeeList = employeeService.getAll();
		Set<WorkType> workTypeSet = new HashSet<>();
		Set<Employee> employeeSet = new HashSet<>();
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try {
			workbook = new XSSFWorkbook(input);
	        sheet = workbook.getSheetAt(0);
	        Iterator<Row> rowIterator = sheet.iterator();
	        rowIterator.next();
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            
	            Work work = new Work();
	            
	            int k = 0;
	            work.setTitle(row.getCell(k++).getStringCellValue());
	            work.setAuthor(row.getCell(k++).getStringCellValue());       
	            work.setDate(row.getCell(k++).getDateCellValue());
	            
	            String workTypeString = row.getCell(k++).getStringCellValue();
	            String[] types = workTypeString.split(",");
	            for(int i = 0; i<types.length; i++){
	            	for(WorkType type : workTypeList){
	            		if(types[i].equals(type.getTitle())){
	            			workTypeSet.add(type);
	            		}
	            	}
	            }
	            work.setTypes(workTypeSet);
	            String categoryString = row.getCell(k++).getStringCellValue();
	            for(Category category : categoryList){
	            	if(categoryString.equals(category.getTitle())){
	            		work.setCategory(category);
	            	}
	            }
	            work.setOutput(row.getCell(k++).getStringCellValue());

	            String[] employees = row.getCell(k++).getStringCellValue().split(",");
	            for(int i = 0; i<employees.length; i++){
	            	for(Employee employee : employeeList){
	            		if(employees[i].equals(employee.getSNP())){    
	            			employeeSet.add(employee);
	            		}
	            	}
	            }
	            work.setEmployees(employeeSet);
	            
	            workService.addWork(work);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

}
