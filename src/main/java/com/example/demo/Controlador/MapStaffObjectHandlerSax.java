package com.example.demo.Controlador;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.example.demo.Modelo.Empresa;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class MapStaffObjectHandlerSax extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();
    List<Empresa> result;
    Empresa empresa;
    
    
    public List<Empresa> getResult() {
        return result;
    }

    @Override
    public void startDocument() {
        result = new ArrayList<>();
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

    	//inicializo el contador
    	Long contador=(long) 0;
        // reset the tag value
        currentValue.setLength(0);
      
    	
        //System.out.println(qName);
        
        // start of loop
        if (qName.equalsIgnoreCase("NroContrato")) {

            // new Empresa
            empresa = new Empresa();

            //se hace un contador para el id, ya que no se posee el atributo NroContrato=
            //String id = attributes.getValue("NroContrato");--> no retorna nada
            contador=contador+1;
            empresa.setNroContrato(contador);
            
            //Set all required attributes in any XML element here itself
            
        }

        /*if (qName.equalsIgnoreCase("salary")) {
            // salary currency
            String currency = attributes.getValue("currency");
            currentStaff.setCurrency(currency);
        }*/

    }

    public void endElement(String uri,
                           String localName,
                           String qName) {

    	/*if (qName.equalsIgnoreCase("NroContrato")) {
            empresa.setNroContrato(Long.parseLong(currentValue.toString()));
        }*/
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
        	empresa.setCODIGOPOSTAL(Long.valueOf(currentValue.toString()));
        }
        
        if (qName.equalsIgnoreCase("Productor")) {
        	empresa.setPRODUCTOR(currentValue.toString());
        }

        // end of loop
        if (qName.equalsIgnoreCase("Empresa")) {
            result.add(empresa);
            //System.out.println("grabó");
        }

    }

    public void characters(char ch[], int start, int length) {
        currentValue.append(ch, start, length);

    }

}
