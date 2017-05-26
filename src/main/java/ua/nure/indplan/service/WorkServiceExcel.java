package ua.nure.indplan.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import ua.nure.indplan.exeptions.ExcelDocException;

@Service
public interface WorkServiceExcel {
	
	void addWorksExel (InputStream input) throws ExcelDocException;

}
