package com.example.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller 
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("/report")
	public void report (HttpServletResponse response) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/Libro.jasper");
	    Map<String, Object> params = new HashMap<String, Object>();
	    
	    List<Libro> listLibro = libroService.getAllLibros();
	    
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLibro);
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "filename=reporte_Libro.pdf");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
}
