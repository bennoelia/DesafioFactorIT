package com.example.demo.Controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Empresa;

//Clase encargada de gestionar el servicio REST

 
@RestController
@RequestMapping("Empresas")
public class ExcelControladorRest {
     	
	@PostMapping( value = "", consumes = MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity <Empresa> postXmlEmpresa( @RequestBody  Empresa empresaXML) throws IOException
	{
	    Empresa returnValue=new Empresa();
	    returnValue.setNroContrato(empresaXML.getNroContrato());
	    returnValue.setDENOMINACION(empresaXML.getDENOMINACION());
	    returnValue.setDOMICILIO(empresaXML.getDOMICILIO());
	    returnValue.setCUIT(empresaXML.getCUIT());
	    returnValue.setCODIGOPOSTAL(empresaXML.getCODIGOPOSTAL());
	    returnValue.setPRODUCTOR(empresaXML.getPRODUCTOR());
	    
	    return new ResponseEntity <Empresa>(returnValue,HttpStatus.OK);
	}
	

 
}
