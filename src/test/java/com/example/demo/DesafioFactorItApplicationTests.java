package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Modelo.ExcelPOIHelper;

@SpringBootTest
class DesafioFactorItApplicationTests {
	private ExcelPOIHelper excelPOIHelper;
	private static String FILE_NAME = "excel.xlsx";
    private String fileLocation;
	

    //@Before
	void contextLoads() {
		System.out.println("Se genera el Excel en base a Examen-FIT.xml");
		/*File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + FILE_NAME;

        excelPOIHelper = new ExcelPOIHelper();
        excelPOIHelper.writeExcel();*/
		
	}
	
	@Test
    public void whenParsingPOIExcelFile_thenCorrect() throws IOException {
		System.out.println("El Excel se generó correctamente");
		System.out.println("Se genera el Excel en base a Examen-FIT.xml");
		File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + FILE_NAME;
        excelPOIHelper = new ExcelPOIHelper();
        //excelPOIHelper.writeExcel();
		
		Map<Integer, List<String>> data
        = excelPOIHelper.readExcel(fileLocation);
		 assertEquals("NroContrato", data.get(0).get(0));
	     assertEquals("CUIT", data.get(0).get(1));
	     assertEquals("CUIT", data.get(0).get(2));
	     //assertEquals("John Smith", data.get(1).get(0));
	     //assertEquals("20", data.get(1).get(1));

	}
	
	
}
