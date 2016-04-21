package com.jasperreport.shiro;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;

import org.jpedal.examples.viewer.Viewer;

public class ShiroMainTest {

	public static void main(String... arg) {
		// "C:/Users/marwan/Desktop/testDR/sample_report.pdf"
		Viewer viewer = new Viewer(new Accessible() {

			@Override
			public AccessibleContext getAccessibleContext() {
				return null;
			}
		}, null);
		// viewer.getPdfDecoder().add
		System.out.println(viewer.getSwingGUI().getDisplayPane());
		viewer.setupViewer();
	}
}
