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
				
	}
	
	@Test
    public void whenParsingPOIExcelFile_thenCorrect() throws IOException {
		System.out.println("El Excel fue generado- Inicio de Prueba Unitaria");
		File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + FILE_NAME;
        excelPOIHelper = new ExcelPOIHelper();
		Map<Integer, List<String>> data
        = excelPOIHelper.readExcel(fileLocation);
		 assertEquals("NroContrato", data.get(0).get(0));
	     assertEquals("CUIT", data.get(0).get(1));
	     //assertEquals("CUIT", data.get(0).get(2));
	     assertEquals("111111111111", data.get(1).get(1));

	}
	
	
}
