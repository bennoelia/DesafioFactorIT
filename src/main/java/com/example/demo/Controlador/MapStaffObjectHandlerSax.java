package com.example.demo.Controlador;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.demo.Modelo.Empresa;
import com.example.demo.Modelo.Movimiento;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class MapStaffObjectHandlerSax extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();
    List<Empresa> result;
    Empresa empresa;
    List<Movimiento> result2;
    Movimiento movimiento;
    
    
    public List<Empresa> getResult() {
        return result;
    }
    
    public List<Movimiento> getResult2() {
        return result2;
    }

    @Override
    public void startDocument() {
        result = new ArrayList<>();
        result2 = new ArrayList<>();
    }
    
    

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes)throws SAXException {

    	
        // reset the tag value
        currentValue.setLength(0);
      
    	
        //System.out.println(qName);
        
        // start of loop Empresas
        if (qName.equalsIgnoreCase("Empresa")) {
        	empresa = new Empresa();
        }
        
     // start of loop Movimientos
        if (qName.equalsIgnoreCase("Movimiento")) {
        	movimiento = new Movimiento();
        }

        
    }

    public void endElement(String uri,
                           String localName,
                           String qName)throws SAXException {

    	
    	if (qName.equalsIgnoreCase("NroContrato")) {
            try {
            	empresa.setNroContrato(Long.parseLong(currentValue.toString()));
            }
            catch(NumberFormatException e) {
            	System.out.println("No se encuentra el formato correcto en Nro Contrato " + currentValue.toString() );
            	e.printStackTrace();
            }    
            /*try {
            	movimiento.setNroContrato(Long.parseLong(currentValue.toString()));
            }
            catch(NumberFormatException e) {
            	System.out.println("No se encuentra el formato correcto en Nro Contrato " + currentValue.toString() );
            	e.printStackTrace();
            }   */ 
        }
        if (qName.equalsIgnoreCase("CUIT")) {
            empresa.setCUIT(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("Denominacion")) {
        	empresa.setDENOMINACION(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("Domicilio")) {
        	empresa.setDOMICILIO(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("CodigoPostal")) {
        	try {
        		empresa.setCODIGOPOSTAL(Long.valueOf(currentValue.toString()));
            }
            catch(NumberFormatException e) {
            	System.out.println("No se encuentra el formato correcto en CodigoPostal " + currentValue.toString() );
            	e.printStackTrace();
            }
        }
        
        if (qName.equalsIgnoreCase("Productor")) {
        	empresa.setPRODUCTOR(currentValue.toString());
        }
        
        //Tags Específicos de Movimientos
        
        if (qName.equalsIgnoreCase("SaldoCtaCte")) {
        	movimiento.setNroContrato(empresa.getNroContrato());
        	try {
        		movimiento.setSaldoCtaCte(Double.valueOf(currentValue.toString()));
            }
            catch(NumberFormatException e) {
            	System.out.println("No se encuentra el formato correcto en SaldoCtaCte " + currentValue.toString() );
            	e.printStackTrace();
            }
        }
        
        if (qName.equalsIgnoreCase("Concepto")) {
        	movimiento.setConcepto(currentValue.toString());
        }
        
        if (qName.equalsIgnoreCase("Importe")) {
        	try {
        		movimiento.setImporte(Double.valueOf(currentValue.toString()));
            }
            catch(NumberFormatException e) {
            	System.out.println("No se encuentra el formato correcto en Importe " + currentValue.toString() );
            	e.printStackTrace();
            }
        }

        if (qName.equalsIgnoreCase("Empresa")) {
            result.add(empresa);
            //System.out.println("grabó");
        }
        
        if (qName.equalsIgnoreCase("Movimiento")) {
        	//System.out.println(movimiento.getNroContrato());
            result2.add(movimiento);
            
        }

    }

    public void characters(char ch[], int start, int length)throws SAXException {
        currentValue.append(ch, start, length);

    }

}
