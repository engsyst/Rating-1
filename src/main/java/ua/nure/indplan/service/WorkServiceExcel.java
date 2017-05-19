package ua.nure.indplan.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public interface WorkServiceExcel {
	
	void addWorksExel(InputStream input);

}
