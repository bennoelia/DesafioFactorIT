package com.example.demo;

import com.example.demo.Modelo.Empresa;
import com.example.demo.Modelo.Movimiento;
import com.example.demo.Controlador.CustomErrorHandlerSax;
import com.example.demo.Controlador.ExcelControlador;
import com.example.demo.Controlador.MapStaffObjectHandlerSax;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DesafioFactorItApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DesafioFactorItApplication.class, args);
		SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream is = getXMLFileAsStream()) {
        	
        	SAXParser saxParser = factory.newSAXParser();
            // parse XML and map to object, it works, but not recommend, try JAXB
            MapStaffObjectHandlerSax handler = new MapStaffObjectHandlerSax();
            //saxParser.parse(is, handler);
            // more options for configuration
            XMLReader xmlReader = saxParser.getXMLReader();
            // set our custom error handler
            xmlReader.setErrorHandler(new CustomErrorHandlerSax(System.err));
            xmlReader.setContentHandler(handler);
            InputSource source = new InputSource(is);
            xmlReader.parse(source);
            
            // se imprime en Consola las Empresas
            List<Empresa> result = handler.getResult();
            //EmpresaServicio serv=new EmpresaServicio();
            //result.forEach(System.out::println);
            System.out.println("*******************Empresas***************************");
            for (Empresa empresa : result) {
                System.out.println("Nro Contrato: " + empresa.getNroContrato() + "- Denominación: " + empresa.getDENOMINACION());
                if (empresa.validarCampos()!=("")){
                	System.out.println(empresa.validarCampos());}
            }
            
            //se imprime en Consola los movimientos
            List<Movimiento> result2 = handler.getResult2();
            System.out.println("*******************Movimientos por Nro Contrato***************************");
            for (Movimiento movimiento : result2) {
                System.out.println("Nro Contrato: " + movimiento.getNroContrato() + "- Saldo Cta Cte: " +movimiento.getSaldoCtaCte());
                if (movimiento.validarCampos()!=("")){
                	System.out.println(movimiento.validarCampos());}
            }
            
            //Generación del excel
            ExcelControlador myReport = new ExcelControlador();
            myReport.exportToExcel(result,result2);
            File file = new File("");
    		String directoryName = file.getAbsoluteFile().toString();
    		System.out.println("**************************El Excel fue generado en: " +directoryName);
            
           

        } catch (ParserConfigurationException | SAXException |  IOException e) {
            e.printStackTrace();
        }

    }

    // get XML file from resources folder.
    private static InputStream getXMLFileAsStream() {
        return DesafioFactorItApplication.class.getClassLoader().getResourceAsStream("Examen-FIT.xml");
    }

}
