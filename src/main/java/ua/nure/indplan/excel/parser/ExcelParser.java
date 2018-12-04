package ua.nure.indplan.excel.parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ua.nure.indplan.excel.parser.entity.Discipline;
import ua.nure.indplan.excel.parser.entity.DisciplineHolder;
import ua.nure.indplan.excel.parser.entity.EntityWithHours;
import ua.nure.indplan.excel.parser.entity.ParsedExcelDisciplines;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {/*

    private static final String SPRING_PART = "Весняний семестр";
    private static final String AUTUMN_PART = "Осінній семестр";
    private static final String TOTAL_OF_YEAR_VALUE = "Усього за рік";]
    private static final String DISCIPLINE = "Дисципліна";
    private static final String TOTAL = "Дисципліна";


    private static final DataFormatter dataFormatter = new DataFormatter();

    public static ParsedExcelDisciplines getParsedExel(InputStream streamWithExcelData) throws IOException {
        int autumnRowNumber = 0;
        int springRowNumber = 0;
        int totalOfYearRowNumber = 0;

        Workbook workbook = new HSSFWorkbook(streamWithExcelData);

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellContent = dataFormatter.formatCellValue(cell).trim();
                if (SPRING_PART.equals(cellContent)) {
                    springRowNumber = row.getRowNum();
                } else if (AUTUMN_PART.equals(cellContent)) {
                    autumnRowNumber = row.getRowNum();
                } else if (TOTAL_OF_YEAR_VALUE.equals(cellContent)) {
                    totalOfYearRowNumber = row.getRowNum();
                }
            }
        }

        List<Discipline> autumnDisciplines = new ArrayList<>();
        List<Discipline> springDisciplines = new ArrayList<>();

        for (int rowNumber = autumnRowNumber + 1; rowNumber < springRowNumber - 1; rowNumber++) {
            Discipline dicipline = getDisciplineFromRow(sheet.getRow(rowNumber));
            dicipline.setSemester(AUTUMN_SEMESTER);
            autumnDisciplines.add(dicipline);
        }

        DisciplineHolder autumnDisciplineHolder = getHolderWithoutDisciplines(sheet.getRow(springRowNumber - 1));
        autumnDisciplineHolder.setDisciplines(autumnDisciplines);
        autumnDisciplineHolder.setSemester(AUTUMN_SEMESTER);

        for (int rowNumber = springRowNumber + 1; rowNumber < totalOfYearRowNumber - 1; rowNumber++) {
            Discipline dicipline = getDisciplineFromRow(sheet.getRow(rowNumber));
            dicipline.setSemester(SPRING_SEMESTER);
            springDisciplines.add(dicipline);
        }

        DisciplineHolder springDisciplineHolder = getHolderWithoutDisciplines(sheet.getRow(totalOfYearRowNumber - 1));
        autumnDisciplineHolder.setDisciplines(springDisciplines);
        springDisciplineHolder.setSemester(SPRING_SEMESTER);

        ParsedExcelDisciplines parsedExcelDisciplines = new ParsedExcelDisciplines(autumnDisciplineHolder, springDisciplineHolder);
        fillHours(parsedExcelDisciplines, sheet.getRow(totalOfYearRowNumber));

        workbook.close();
        return parsedExcelDisciplines;
    }

    private static DisciplineHolder getHolderWithoutDisciplines(Row row) {
        DisciplineHolder disciplineHolder = new DisciplineHolder();
        fillHours(disciplineHolder, row);
        return disciplineHolder;
    }

    private static int getValueByFormula(Cell cell) {
        return (int) cell.getNumericCellValue();
    }

    private static Discipline getDisciplineFromRow(Row row) {
        int currentCell = 0;
        Discipline discipline = new Discipline()
                .setName(getCellStringValue(row.getCell(currentCell++)))
                .setGroups(getGroupsFromCell(row.getCell(currentCell++)))
                .setStudentsCount(getIntCellValue(row.getCell(currentCell++)))
                .setControlType(getCellStringValue(row.getCell(currentCell++)));
        fillHours(discipline, row);
        return discipline;
    }

    private static void fillHours(EntityWithHours entityWithHours, Row row) {
        int currentCell = DEFAULT_START_POSITION_FOR_TOTAL_COUNTING;
        entityWithHours
                .setLectureHours(getValueByFormula(row.getCell(currentCell++)))
                .setPracticalTypeHours(getValueByFormula(row.getCell(currentCell++)))
                .setLaboratoryHours(getValueByFormula(row.getCell(currentCell++)))
                .setConsultationHours(getValueByFormula(row.getCell(currentCell++)))
                .setKpkrHours(getValueByFormula(row.getCell(currentCell++)))
                .setControleWorksHours(getValueByFormula(row.getCell(currentCell++)))
                .setSemesterControlHours(getValueByFormula(row.getCell(currentCell++)))
                .setDiplomHours(getValueByFormula(row.getCell(currentCell++)))
                .setEkHours(getValueByFormula(row.getCell(currentCell++)))
                .setAspirantHours(getValueByFormula(row.getCell(currentCell++)))
                .setMagisterHours(getValueByFormula(row.getCell(currentCell++)))
                .setPracticeHours(getValueByFormula(row.getCell(currentCell++)))
                .setTotalHours(getValueByFormula(row.getCell(currentCell++)));
    }

    private static String getCellStringValue(Cell cell) {
        return dataFormatter.formatCellValue(cell).trim();
    }

    private static int getIntCellValue(Cell cell) {
        return Integer.parseInt(dataFormatter.formatCellValue(cell).trim());
    }

    private static List<String> getGroupsFromCell(Cell cell) {
        List<String> groups = new ArrayList<>();
        for (String group : getCellStringValue(cell).split(COMMA)) {
            groups.add(group.trim());
        }
        return groups;
    }*/
}
