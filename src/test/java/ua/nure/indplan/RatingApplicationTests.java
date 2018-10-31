package ua.nure.indplan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import ua.nure.indplan.RatingApplication;
import ua.nure.indplan.excel.parser.ExcelParserTest;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { 
//		RatingApplication.class, 
		ExcelParserTest.class, 
	})
@WebAppConfiguration
public class RatingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
