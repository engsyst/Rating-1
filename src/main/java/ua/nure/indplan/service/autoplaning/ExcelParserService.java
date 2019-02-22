package ua.nure.indplan.service.autoplaning;

import org.springframework.web.multipart.MultipartFile;

import ua.nure.indplan.entity.autoplaning.Plan;

import java.io.IOException;

public interface ExcelParserService {

    Plan createAndSavePlanFromMultipartFile(MultipartFile file) throws IOException;
}
