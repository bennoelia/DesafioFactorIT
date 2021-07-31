package com.example.demo.Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Clase encargada de la lectura de un Excel cuya ruta se recibe como parámetro.
//Esta clase fue creada específicamente para el desarrollo de la prueba unitaria.

public class ExcelPOIHelper {
	public Map<Integer, List<String>> readExcel(String fileLocation) throws IOException {
    	FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING: data.get(new Integer(i)).add(cell.getRichStringCellValue().getString()); break;
                    //por cuestiones de tiempo no llegué a codificar las opción para todos los tipos de datos
                    /*case NUMERIC: ... break;
                    case BOOLEAN: ... break;
                    case FORMULA: ... break;*/
                    default: data.get(new Integer(i)).add(" ");
                }
            }
            i++;
        }
        if (workbook != null){
            workbook.close();
        }
        return data;
    }

	
	
}
