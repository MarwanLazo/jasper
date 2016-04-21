package com.jasperreport.main;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportExporter {

	public ReportExporter(JasperPrint jasperPrint) throws JRException {
		String path = "C:/Users/marwan/Desktop/testDR/sample_report";
		// PDF exporter
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + exporterType.PDF.getFormat());
		// XML exporter
		JasperExportManager.exportReportToXmlFile(jasperPrint, path + exporterType.XML.getFormat(), true);
		// HTML exporter
		JasperExportManager.exportReportToHtmlFile(jasperPrint, path + exporterType.HTML.getFormat());
		// XLS exporter
		JRXlsExporter exporter = new JRXlsExporter();
		SimpleExporterInput input = new SimpleExporterInput(jasperPrint);
		exporter.setExporterInput(input);
		OutputStreamExporterOutput exporterOutputXLS = new SimpleOutputStreamExporterOutput(new File(path + exporterType.XLS.getFormat()));
		exporter.setExporterOutput(exporterOutputXLS);
		exporter.exportReport();
		// XLSx exporter
		JRXlsxExporter xlsxExporter = new JRXlsxExporter();
		SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		xlsxExporter.setExporterInput(exporterInput);
		OutputStreamExporterOutput exporterOutputXLSX = new SimpleOutputStreamExporterOutput(new File(path + exporterType.XLSX.getFormat()));
		xlsxExporter.setExporterOutput(exporterOutputXLSX);
		xlsxExporter.exportReport();

	}

	public static enum exporterType {
		PDF(".pdf"), XLS(".xls"), XLSX(".xlsx"), HTML(".html"), XML(".xml");

		private String format;

		private exporterType(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String extension) {
			this.format = extension;
		}

	}

}
