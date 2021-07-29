package com.example.demo;

import org.springframework.boot.SpringApplication;
import com.example.demo.Modelo.Empresa;
import com.example.demo.Controlador.CustomErrorHandlerSax;
import com.example.demo.Controlador.MapStaffObjectHandlerSax;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
            
            // print all
            List<Empresa> result = handler.getResult();
            //result.forEach(System.out::println);
            for (Empresa empresa : result) {
                System.out.println(empresa.getDENOMINACION());
                System.out.println(empresa.validarCampos());
            }
           

        } catch (ParserConfigurationException | SAXException |  IOException e) {
            e.printStackTrace();
        }

    }

    // get XML file from resources folder.
    private static InputStream getXMLFileAsStream() {
        return DesafioFactorItApplication.class.getClassLoader().getResourceAsStream("Examen-FIT2.xml");
    }

}
