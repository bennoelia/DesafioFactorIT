package com.example.demo.Controlador;

import org.springframework.http.MediaType;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//Clase encargada de gestionar la petición de generación del Excel, 
//instanciando un objeto de la clase EmpresasMovsExcelExporter con las listas de Empresas y Movimientos.
 
@RestController
public class ExcelControladorRest {
 
    
        
	@PostMapping( value = "", consumes = MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public void postXmlMetadata( HttpServletRequest request, HttpServletResponse response ) throws IOException
	{
	    response.setContentType( MediaType.APPLICATION_XML_VALUE );

	    response.getOutputStream();
	}
	
	

 
}
