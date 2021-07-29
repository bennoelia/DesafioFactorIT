package com.example.demo.Controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Modelo.Empresa;
import com.example.demo.Modelo.EmpresasMovsExcelExporter;
import com.example.demo.Servicio.EmpresaServicio;
 
@Controller
public class ExcelControlador {
 
    //@Autowired
    //private EmpresaServicio service;
     
     
    @GetMapping("/users/export/excel")// ver si uso esta opción
    //public void exportToExcel(HttpServletResponse response,
    public void exportToExcel(
    						List<Empresa> listEmpresas) throws IOException {
        //response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        //String headerKey = "Content-Disposition";
        //String headerValue = "attachment; filename=EmpresasMovs_" + currentDateTime + ".xlsx";
        //response.setHeader(headerKey, headerValue);
        
        //List<Empresa> listEmpresas = service.listAll(listEmpresas);
         
        EmpresasMovsExcelExporter excelExporter = new EmpresasMovsExcelExporter(listEmpresas);
         
        //excelExporter.export(response);
        excelExporter.export();
    }  
 
}
