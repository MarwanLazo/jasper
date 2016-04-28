package com.jasperreport.shiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ShiroMainTest {

	public static void main(String... arg) {

		// // create object of JLabel and set label
		// JLabel label = new JLabel("Selected Date:");
		// // create object of JTextField and declare it final
		// final JTextField text = new JTextField(20);
		// // create object of JButton
		// JButton b = new JButton("popup");
		// // create object of JPanel
		// JPanel p = new JPanel();
		// p.add(label);
		// p.add(text);
		// p.add(b);
		//
		// final JFrame f = new JFrame();
		// f.getContentPane().add(p);
		// f.pack();
		// f.setVisible(true);
		// // add action listener
		// b.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent ae) {
		// // set text i.e. date
		// text.setText(new DatePicker(f).setPickedDate());
		// }
		// });
		// JButton button = new JButton("get Date");
		// p.add(button);
		// button.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// String txt = text.getText();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//
		// System.out.println(text.getText());
		// try {
		// System.out.println(format.parse(txt));
		// } catch (ParseException e1) {
		// e1.printStackTrace();
		// }
		// }
		// });

		/*
		 * DecimalFormat df = new DecimalFormat("#.##");
		 * df.setRoundingMode(RoundingMode.CEILING); String x =
		 * df.format(-12.877883); System.out.println(Double.valueOf(x)); x =
		 * df.format(-12.877883); System.out.println(Double.valueOf(x));
		 */

		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		UtilDateModel model = new UtilDateModel();
		// model.setDate(20,04,2014);
		// Need this...

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		// Don't know about the formatter, but there it is...
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.add(datePicker);
		frame.getContentPane().add(panel);
		JButton button = new JButton("date");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(datePicker.getJFormattedTextField().getText());
					String DATE_PATTERN = "yyyy-MM-dd";
					SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
					System.out.println(dateFormat.parse(datePicker.getJFormattedTextField().getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static class DateLabelFormatter extends AbstractFormatter {

		private static final long	serialVersionUID	= 1L;
		private String				datePattern			= "yyyy-MM-dd";
		private SimpleDateFormat	dateFormatter		= new SimpleDateFormat(datePattern);

		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		public String valueToString(Object value) {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

}
