package ua.nure.indplan.excel.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import ua.nure.indplan.excel.parser.entity.ParsedExcelDisciplines;

public class ExcelParserTest {

	final String fName = "test-data/NAgruzka_ Міщеряков Ю. В. (Професор)_old.xls";
	InputStream in;

	@Before
	public void setUp() throws Exception {
		in = new FileInputStream(fName);
	}

	@Test
	public void testGetParsedExel() throws IOException {
//		ExcelParser.getParsedExel(in);
	}

}
