package ua.nure.indplan.service.autoplaning.impl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.nure.indplan.dao.autoplaning.DisciplineAttributeDao;
import ua.nure.indplan.entity.autoplaning.AttributeDisciplineId;
import ua.nure.indplan.entity.autoplaning.Discipline;
import ua.nure.indplan.entity.autoplaning.DisciplineAttribute;
import ua.nure.indplan.entity.autoplaning.DisciplineHasAttribute;
import ua.nure.indplan.entity.autoplaning.Plan;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.autoplaning.ExcelParserService;
import ua.nure.indplan.service.autoplaning.PlanService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ExcelParserServiceImpl implements ExcelParserService {

    private static final String SPRING_PART = "Весняний семестр";
    private static final String AUTUMN_PART = "Осінній семестр";
    private static final String TOTAL_OF_YEAR_VALUE = "Усього за рік";
    private static final DataFormatter dataFormatter = new DataFormatter();
    @Autowired
    private DisciplineAttributeDao attributeDao;
    @Autowired
    private PlanService planService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Plan createAndSavePlanFromMultipartFile(MultipartFile file) throws IOException {
        List<DisciplineAttribute> allDisciplineAttributes = attributeDao.findAll();
        InputStream inputStream = file.getInputStream();
        Plan plan;

        int autumnRowNumber = 0;
        int springRowNumber = 0;
        int attributesRowNumber = 0;
        int totalOfYearRowNumber = 0;

        Workbook workbook = new HSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Set<Discipline> planDisciplines = new HashSet<>();

        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellContent = dataFormatter.formatCellValue(cell).trim();
                if (SPRING_PART.equals(cellContent)) {
                    springRowNumber = row.getRowNum();
                } else if (AUTUMN_PART.equals(cellContent)) {
                    autumnRowNumber = row.getRowNum();
                    attributesRowNumber = autumnRowNumber - 2;
                } else if (TOTAL_OF_YEAR_VALUE.equals(cellContent)) {
                    totalOfYearRowNumber = row.getRowNum();
                }
            }
        }

        Row attributesRow = sheet.getRow(attributesRowNumber);
        Map<DisciplineAttribute, Integer> cellIndexesForAttributes = getCellIndexesForAttributes(attributesRow, allDisciplineAttributes);
        cellIndexesForAttributes.putAll(getCellIndexesForAttributes(sheet.getRow(attributesRowNumber - 1), allDisciplineAttributes));
        plan = new Plan();

        for (int rowNumber = autumnRowNumber + 1; rowNumber < springRowNumber - 1; rowNumber++) {
            Discipline discipline = new Discipline();
            Row row = sheet.getRow(rowNumber);
            discipline.setDisciplineHasAttributes(retrieveExistingAttributesFromRow(row, cellIndexesForAttributes, discipline));
            planDisciplines.add(discipline);
            discipline.setName("aaa");
            discipline.setPlan(plan);
        }

        for (int rowNumber = springRowNumber + 1; rowNumber < totalOfYearRowNumber - 1; rowNumber++) {
            Discipline discipline = new Discipline();
            Row row = sheet.getRow(rowNumber);
            discipline.setDisciplineHasAttributes(retrieveExistingAttributesFromRow(row, cellIndexesForAttributes, discipline));
            planDisciplines.add(discipline);
            discipline.setName("aaa");
            discipline.setPlan(plan);
        }
        plan.setRate(0);
        plan.setStartYear(1998);

        plan.setEmployee(employeeService.getById(1));
        plan.setDisciplines(planDisciplines);

        return planService.savePlan(plan);
    }

    private Set<DisciplineHasAttribute> retrieveExistingAttributesFromRow(Row row,
                                                                          Map<DisciplineAttribute, Integer> existingAttributes,
                                                                          Discipline discipline) {
        Set<DisciplineHasAttribute> disciplineAttributes = new HashSet<>();
        for (Map.Entry<DisciplineAttribute, Integer> entry : existingAttributes.entrySet()) {
            DisciplineHasAttribute disciplineAttribute = new DisciplineHasAttribute(
                    new AttributeDisciplineId(discipline, entry.getKey()),
                    row.getCell(entry.getValue()).toString());
            disciplineAttributes.add(disciplineAttribute);
        }
        return disciplineAttributes;
    }

    private Map<DisciplineAttribute, Integer> getCellIndexesForAttributes(Row attributesRow,
                                                                          Collection<DisciplineAttribute> allDisciplineAttributes) {
        Map<DisciplineAttribute, Integer> attributeIndexes = new HashMap<>();

        for (Cell attributeCell : attributesRow) {
            for (DisciplineAttribute disciplineAttribute : allDisciplineAttributes) {
                if (disciplineAttribute.getName().trim().equals(attributeCell.toString().trim())) {
                    attributeIndexes.put(disciplineAttribute, attributeCell.getColumnIndex());
                    break;
                }
            }
        }

        return attributeIndexes;
    }
}
