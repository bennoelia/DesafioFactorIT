package com.example.demo.Modelo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class EmpresasMovsExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Empresa> listEmpresas;
    private List<Movimiento> listMovimientos;
     
    public EmpresasMovsExcelExporter(List<Empresa> listEmpresas, List<Movimiento> listMovimientos) {
        this.listEmpresas = listEmpresas;
        this.listMovimientos=listMovimientos;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Empresas");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
       
         
        createCell(row, 0, "NroContrato", style);      
        createCell(row, 1, "CUIT", style);       
        createCell(row, 2, "DENOMINACION", style);    
        createCell(row, 3, "DOMICILIO", style);
        createCell(row, 4, "CODIGOPOSTAL", style);
        createCell(row, 5, "PRODUCTOR", style);
         
    }
    
    private void writeHeaderLine2() {
        sheet = workbook.createSheet("Movimientos");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
       
         
        createCell(row, 0, "NroContrato", style);      
        createCell(row, 1, "SaldoCtaCte", style);       
        createCell(row, 2, "Concepto", style);    
        createCell(row, 3, "Importe", style);
                
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } 
        if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        if (value instanceof String) {
            cell.setCellValue((String) value);
        }
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Empresa empresa : listEmpresas) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, empresa.getNroContrato(), style);
            createCell(row, columnCount++, empresa.getCUIT(), style);
            createCell(row, columnCount++, empresa.getDENOMINACION(), style);
            createCell(row, columnCount++, empresa.getDOMICILIO(), style);
            createCell(row, columnCount++, empresa.getCODIGOPOSTAL(), style);
            createCell(row, columnCount++, empresa.getPRODUCTOR(), style);
             
        }
    }
    
    private void writeDataLines2() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Movimiento movimiento : listMovimientos) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, movimiento.getNroContrato(), style);
            createCell(row, columnCount++, movimiento.getSaldoCtaCte(), style);
            createCell(row, columnCount++, movimiento.getConcepto(), style);
            createCell(row, columnCount++, movimiento.getImporte(), style);
                     
        }
    }
 
     
    //public void export(HttpServletResponse response) throws IOException {
    public void export() throws IOException {
        writeHeaderLine();
        writeDataLines();
        writeHeaderLine2();
        writeDataLines2();
        
        //ServletOutputStream outputStream = response.getOutputStream();
        //workbook.write(outputStream);
        //workbook.close();
         
        //outputStream.close();
        
        OutputStream fileOut=new FileOutputStream("excel.xlsx");
        workbook.write(fileOut);
         
    }
}
