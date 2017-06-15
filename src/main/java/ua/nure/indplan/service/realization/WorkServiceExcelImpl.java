package ua.nure.indplan.service.realization;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.indplan.controller.WorkController;
import ua.nure.indplan.dao.WorkDao;
import ua.nure.indplan.entity.Category;
import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.entity.Work;
import ua.nure.indplan.entity.WorkType;
import ua.nure.indplan.exeptions.ExcelDocException;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.WorkService;
import ua.nure.indplan.service.WorkServiceExcel;
import ua.nure.indplan.service.WorkTypeService;

@Service
public class WorkServiceExcelImpl implements WorkServiceExcel{
	
    Logger logger = LoggerFactory.getLogger(WorkController.class);
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	WorkTypeService workTypeService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	WorkDao workDaoService;
	
	@Transactional
	public void addWorksExel(InputStream input) throws ExcelDocException{
		
		List<Work> workList = new ArrayList();
		List<String> firstStringList = new ArrayList<>();
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
	        Row row = rowIterator.next();  
	        for (int i = 0; i<7; i++){
		        firstStringList.add(row.getCell(i).getStringCellValue());
	        }
	        // rowIterator.next();
	        while (rowIterator.hasNext())
	        {
	            row = rowIterator.next();
	            
	            Work work = new Work();
	            row.getRowNum();
	            for (int i = 0; i<7; i++){
	            	 switch (firstStringList.get(i)) {
	 				case "Title":
	 					work.setTitle(getRowStringData(row, i));
	 					break;
	 				case "Authors":
	 					work.setAuthor(getRowStringData(row, i));
	 					break;
	 				case "Date":
	 					work.setDate(getRowDateData(row, i));
	 					break;
	 				case "Category":
	 					String categoryString = getRowStringData(row, i);
	 		            for(Category category : categoryList){
	 		            	if(categoryString.equals(category.getTitle())){
	 		            		work.setCategory(category);
	 		            	}
	 		            }
	 					break;
	 				case "Output":
	 					work.setOutput(getRowStringData(row, i));
	 					break;
	 				case "Employees":
	 		            String[] employees = getRowStringData(row, i).split("\\s*,\\s*");
	 		            for(int j = 0; j<employees.length; j++){
	 		            	for(Employee employee : employeeList){
	 		            		if(employees[j].equalsIgnoreCase(employee.getSNP()))
	 		            		{
	 		            			employeeSet.add(employee);
	 		            		}
	 		            	}
	 		            }
	 		            work.setEmployees(employeeSet);
	 					break;
	 				case "WorkType":
	 					String workTypeString = getRowStringData(row, i);
	 		            String[] types = workTypeString.split("\\s*,\\s*");
	 		            for(int j = 0; j<types.length; j++){
	 		            	for(WorkType type : workTypeList){
	 		            		if (types[j].equalsIgnoreCase(type.getTitle()))
	 		            		{
	 		            			workTypeSet.add(type);
	 		            		}
	 		            	}
	 		            }
	 		            work.setTypes(workTypeSet);
	 		            
	 					break;
	 				}
	            }
	            workList.add(work);
	            // TODO Import only ALL or NOTHING, so collect into list
	            //workService.addWork(work);
	        }
	        // TODO Add to WorkDao method that add all works in single transaction
	        for (Work w : workList){
		        workDaoService.addWork(w);
	        }
	    } catch (ExcelDocException e) {
	    	// This method never throws any exception
	    	// TODO throw your own RuntimeException
	    	throw e;
	       // e.printStackTrace();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
	    	logger.error("IOException at addWorksExel");
		}
	}
	
	private String getRowStringData(Row row, int i) throws ExcelDocException {
	     try { return row.getCell(i).getStringCellValue();
	    } catch(Exception ex) {
	    	ExcelDocException toThrow = new ExcelDocException();
	        toThrow.setRow(row.getRowNum());
	        toThrow.setColumn(i);
	       throw toThrow;
	    }
	}
	
	private Date getRowDateData(Row row, int i) throws ExcelDocException {
	     try { return row.getCell(i).getDateCellValue();
	    } catch(Exception ex) {
	    	ExcelDocException toThrow = new ExcelDocException();
	        toThrow.setRow(row.getRowNum());
	        toThrow.setColumn(i);
	       throw toThrow;
	    }
	}
}

