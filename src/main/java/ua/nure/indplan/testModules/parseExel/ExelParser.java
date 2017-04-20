package ua.nure.indplan.testModules.parseExel;
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
*/
public class ExelParser {

/*	public static String parse(String fullPath) throws FileNotFoundException, IOException {
		// Discipline discipline;
		// Set<Discipline> disciplineSet = new HashSet<>();
		// PlannedWork plannedWork;
		// Set<PlannedWork> plannedWorkSet = new HashSet<>();

		try (HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(fullPath))) {
			HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
			Iterator<Row> it = myExcelSheet.iterator();
			while (it.hasNext()) {
				Row row = it.next();
				Iterator<Cell> cells = row.iterator();
				System.out.println("~~~~~~~~~~~ROW = " + row.getRowNum() + "~~~~~~~~~~~");
				while (cells.hasNext()) {
					Cell cell = cells.next();
					System.out.println(cell.getColumnIndex() + ": " + getCellValue(cell));
				}
			}
		}
		return null;
	}

	private static Object getCellValue(Cell cell) {
		int cellType = cell.getCellType();
		switch (cellType) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		case Cell.CELL_TYPE_FORMULA:
			return cell.getNumericCellValue();
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		String path = "D:\\LeO\\University\\Диплом\\Мой диплом\\Материалы для диплома\\Примерны нагрузки"
				+ "\\NAgruzka_ Міщеряков Ю. В. (Доцент).xls";
		try {
			parse(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
