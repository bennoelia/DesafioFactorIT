package com.example.demo.Controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Modelo.Empresa;
import com.example.demo.Modelo.EmpresasMovsExcelExporter;
import com.example.demo.Modelo.Movimiento;

//Clase encargada de gestionar la petición de generación del Excel, 
//instanciando un objeto de la clase EmpresasMovsExcelExporter con las listas de Empresas y Movimientos.
 
@Controller
public class ExcelControlador {
 
    //@Autowired
    //private EmpresaServicio service;
     
     
    @GetMapping("/export/excel")
    //public void exportToExcel(HttpServletResponse response,
    public void exportToExcel(List<Empresa> listEmpresas,List<Movimiento> listMovimiento) throws IOException {
    	/*se deja en comentario otras opciones de código
    	//response.setContentType("application/octet-stream");
        //DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        //String currentDateTime = dateFormatter.format(new Date());
        //String headerKey = "Content-Disposition";
        //String headerValue = "attachment; filename=EmpresasMovs_" + currentDateTime + ".xlsx";
        //response.setHeader(headerKey, headerValue);
        //List<Empresa> listEmpresas = service.listAll(listEmpresas);*/
         
        EmpresasMovsExcelExporter excelExporter = new EmpresasMovsExcelExporter(listEmpresas,listMovimiento);
        //excelExporter.export(response);
        excelExporter.export();
    }  
 
}
