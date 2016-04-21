package com.jasperreport.main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.Page;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MainApp extends ReportUtils {

	// private static String PATH =
	// "C:/Users/marwan/Desktop/testDR/sample_report.pdf";
	// private static String SIGNED =
	// "C:/Users/marwan/Desktop/testDR/signed.pdf";

	public static void main(String... args) throws IOException {

		System.out.print("Test App");
		System.out.print("\nTest App");
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(1, "Osama1", 3001, 12.51f));
		emps.add(new Employee(2, "Rady", 3010, 12.52f));
		emps.add(new Employee(3, "Oraby", 3100, 12.53f));
		emps.add(new Employee(4, "Mostafa", 31000, 12.54f));

		try {
			JasperPrint jp = new MainApp().getReport(emps);
			JasperViewer jasperViewer = new JasperViewer(jp);
			new ReportExporter(jp);
			jasperViewer.setVisible(true);
		} catch (ColumnBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DynamicReport getReport() throws ColumnBuilderException, ClassNotFoundException {
		Style headerStyle = createHeaderStyle();
		Style detailTextStyle = createDetailTextStyle();
		Style detailNumStyle = createDetailNumberStyle();

		DynamicReportBuilder report = new DynamicReportBuilder();

		// report.setSubtitle("Commission received by Employee");
		// report.setSubtitleStyle(createSubTitleStyle());

		report.setSubtitle("Commission received by Employee \\n This report was generated at \\n" + new Date() + "\\n This information is confidential \\n")
				// .setSubtitleHeight(new
				// Integer(20))
				.setSubtitleStyle(createSubTitleStyle());

		AbstractColumn columnEmpNo = createColumn("empNo", Integer.class, "Employee Number", 30, headerStyle, detailTextStyle);
		AbstractColumn columnName = createColumn("name", String.class, "Name", 30, headerStyle, detailTextStyle);
		AbstractColumn columnSalary = createColumn("salary", Integer.class, "Salary", 30, headerStyle, detailNumStyle);
		AbstractColumn columnCommission = createColumn("commission", Float.class, "Commission", 30, headerStyle, detailNumStyle);
		report.addColumn(columnEmpNo).addColumn(columnName).addColumn(columnSalary).addColumn(columnCommission);

		report.setTitle("Employee Report");
		report.setTitleStyle(createTitleStyle());
		report.setPageSizeAndOrientation(Page.Page_A4_Portrait());
		report.setUseFullPageWidth(true);
		report.addWatermark("Marwan APP", new Font(40, Font._FONT_GEORGIA, true), Color.GRAY, 30);
		return report.build();
	}

}
